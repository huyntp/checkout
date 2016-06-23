package me.kimhieu.yummy.ecommerceproject.checkout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.kimhieu.yummy.ecommerceproject.R;
import me.kimhieu.yummy.ecommerceproject.model.Product;
import me.kimhieu.yummy.ecommerceproject.model.ProductsResponse;
import me.kimhieu.yummy.ecommerceproject.service.ServiceGenerator;
import me.kimhieu.yummy.ecommerceproject.service.WooCommerceService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zyk on 6/12/2016.
 */
public class CheckOutActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CheckOutRecyclerViewActivity recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    WooCommerceService service =  ServiceGenerator.createService(WooCommerceService.class);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_main_content);
    }
    private void displayCheckoutProduct() {
        Call<ProductsResponse> productsResponseCall = service.getListProduct();

        productsResponseCall.enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                List<Product> checkoutProductList = new ArrayList<Product>();
                for (Product product : response.body().getProducts()) {
                    if (product.getOnSale()) {
                        checkoutProductList.add(product);
                    }
                }
                recyclerViewAdapter.setProductList(checkoutProductList);
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                recyclerViewAdapter.setProductList(new ArrayList<Product>());
            }
        });

    }
}
