package me.kimhieu.yummy.ecommerceproject.checkout;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.kimhieu.yummy.ecommerceproject.R;
import me.kimhieu.yummy.ecommerceproject.explore.ProductListAdapter;
import me.kimhieu.yummy.ecommerceproject.explore.ProductListFragment;
import me.kimhieu.yummy.ecommerceproject.model.Product;

/**
 * Created by zyk on 6/23/2016.
 */
public class CheckOutListFragment extends Fragment {
    private List<Product> produclist;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerViewManager;

  public CheckOutListFragment(List<Product> produclist)
  {
      this.produclist = produclist;
  }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewParent = inflater.inflate(R.layout.checkout_list_fragment, container, false);

        recyclerView = (RecyclerView) viewParent.findViewById(R.id.checkout_list);
        ProductListAdapter productListAdapter = new ProductListAdapter(produclist,viewParent.getContext());
        recyclerViewManager = new LinearLayoutManager(viewParent.getContext());
        recyclerView.setLayoutManager(recyclerViewManager);
        recyclerView.setAdapter(productListAdapter);
        return viewParent;
    }
}
