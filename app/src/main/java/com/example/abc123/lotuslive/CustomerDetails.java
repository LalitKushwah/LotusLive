package com.example.abc123.lotuslive;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomerDetails extends AppCompatActivity {

    String name,email,address,age,lastName;
    TextView custName,emailAddress,custAddress,custAge;
    ArrayList<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        Context context=getApplicationContext();

        list.add("Electronic");
        list.add("Furniture");
        list.add("Item-Demo");
        list.add("Item-Demo");
        custName=(TextView)findViewById(R.id.name);
        emailAddress=(TextView)findViewById(R.id.textView2);
        custAddress=(TextView)findViewById(R.id.textView3);
        custAge=(TextView)findViewById(R.id.textView);

        RecyclerView listRecycler=(RecyclerView)findViewById(R.id.prevItemList);
        listRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ProductAdapter pA=new ProductAdapter(list,context);
        listRecycler.setAdapter(pA);


        TabHost tabs = (TabHost)findViewById(R.id.tabHost);
        tabs.setup();
        tabs.setCurrentTab(0);
        TabHost.TabSpec tspec11 = tabs.newTabSpec("Tab1");
        tspec11.setIndicator("Profile");
        tspec11.setContent(R.id.Profile);
        tabs.addTab(tspec11);

        final TabHost.TabSpec t2 = tabs.newTabSpec("Tab2");
        t2.setIndicator("Product");
        t2.setContent(R.id.Product);
        tabs.addTab(t2);

        Intent i = getIntent();
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
