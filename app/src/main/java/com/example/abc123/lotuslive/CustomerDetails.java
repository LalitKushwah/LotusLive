package com.example.abc123.lotuslive;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomerDetails extends Fragment {

    String name,email,address,age,lastName;
    TextView custName,emailAddress,custAddress,custAge;
    ArrayList<String> list=new ArrayList<>();

    public CustomerDetails() {
        //Empty Constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_customer_details, container, false);

        list.add("Electronic");
        list.add("Furniture");
        list.add("Item-Demo");
        list.add("Item-Demo");
        custName=(TextView)rootView.findViewById(R.id.name);
        emailAddress=(TextView)rootView.findViewById(R.id.textView2);
        custAddress=(TextView)rootView.findViewById(R.id.textView3);
        custAge=(TextView)rootView.findViewById(R.id.textView);

        RecyclerView listRecycler=(RecyclerView)rootView.findViewById(R.id.prevItemList);
        listRecycler.setLayoutManager(new LinearLayoutManager(container.getContext()));
        ProductAdapter pA=new ProductAdapter(list,container.getContext());
        listRecycler.setAdapter(pA);



        Intent i = getActivity().getIntent();
        if(!(i.getStringExtra("name").toString().equals(null))) {

              if(i.getStringExtra("lastName").equals(null)) {
                  lastName = "";
              }
            else
              {
                  lastName=i.getStringExtra("lastName").toString();
              }
                name = i.getStringExtra("name") + " " + lastName;
                custName.setText(name);
                emailAddress.setText(i.getStringExtra("email"));
                custAddress.setText(i.getStringExtra("address"));
                custAge.setText("21");
            }

return rootView;


    }
    class ProductAdapter extends RecyclerView.Adapter<com.example.abc123.lotuslive.CustomerDetails.ProductAdapter.TextViews> {
        ArrayList<String> productList=new ArrayList<>();
        Context context;

        public ProductAdapter(ArrayList<String> productList,Context context) {
            this.productList=productList;
            this.context = context;
        }
        @Override
        public TextViews onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
            TextViews vh = new TextViews(v);
            //v.setOnClickListener(new CustomerListOnClickListner());
            return vh;
        }

        @Override
        public void onBindViewHolder(com.example.abc123.lotuslive.CustomerDetails.ProductAdapter.TextViews holder, int position) {
            holder.getProductName().setText(productList.get(position));

        }



        @Override
        public int getItemCount() {
            return productList.size();
        }

        public class TextViews extends RecyclerView.ViewHolder{
            TextView productName;
            public TextViews(View itemView) {
                super(itemView);
                productName = (TextView) itemView.findViewById(R.id.itemname);

            }
            public TextView getProductName(){return productName;}
        }



    }
}
