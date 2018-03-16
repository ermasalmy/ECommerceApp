package com.oum.e_commerceapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.oum.e_commerceapp.adapter.CategoryAdapter;
import com.oum.e_commerceapp.adapter.ProductAdapter;
import com.oum.e_commerceapp.modal.ProductDomain;

import java.util.ArrayList;

public class ProductActivity extends Activity {
    int itemCount = 0;
    GridView gridView;
    TextView txtItemCount;

    ArrayList<ProductDomain> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        productList = new ArrayList<>();

        int position = getIntent().getIntExtra("position", 0);

        gridView = findViewById(R.id.grid_product);


        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        LayoutInflater inflater = this.getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.description_layout, null));
        builder.create();

        Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_LONG).show();

        ProductDomain productDomain;
        ;

        switch (position) {
            case 0:

                String[] clothList = {"JEANS", "SHIRTS", "PANTS", "T-SHIRTS", "SKIRTS"};
                int[] clothimageList = {R.drawable.jeans, R.drawable.shirt, R.drawable.pants, R.drawable.tshirts, R.drawable.skirts};

                String[] clothpriceList = {"200 MYR", "250 MYR", "100 MYR", "300 MYR", "250 MYR", "200 MYR", "300 MYR"};


                for (int i = 0; i < clothList.length; i++) {

                    productDomain = new ProductDomain(clothList[i], clothpriceList[i], clothimageList[i]);
                    productList.add(productDomain);
                }

                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));


                break;
            case 1:

                String[] electronicList = {"WEBCAM", "LAPTOP", "SCANNER", "KEYBOARD", "SPEAKER"};
                int[] electroimageList = {R.drawable.webcam1, R.drawable.lptop, R.drawable.scanner, R.drawable.keyboard, R.drawable.speaker};

                String[] electropriceList = {"200 MYR", "250 MYR", "100 MYR", "300 MYR", "250 MYR", "200 MYR", "300 MYR"};

                for (int i = 0; i < electronicList.length; i++) {

                    productDomain = new ProductDomain(electronicList[i], electropriceList[i], electroimageList[i]);
                    productList.add(productDomain);
                }

                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));


                break;
            case 2:

                String[] softwareList = {"ANDROID", "LINUX", "MACOS", "WINDOWS10", "FIREFOX"};
                int[] softwareimageList = {R.drawable.android1, R.drawable.linux, R.drawable.macos, R.drawable.window10, R.drawable.firefox};

                String[] softwarepriceList = {"200 MYR", "250 MYR", "100 MYR", "300 MYR", "250 MYR", "200 MYR", "300 MYR"};

                for (int i = 0; i < softwareList.length; i++) {

                    productDomain = new ProductDomain(softwareList[i], softwarepriceList[i], softwareimageList[i]);
                    productList.add(productDomain);
                }

                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));

                break;
            case 3:

                String[] cellphoneList = {"SAMSUNG", "LG", "SONY", "OPPO", "IPHONE"};
                int[] cellphoneimageList = {R.drawable.samsung, R.drawable.lg, R.drawable.sony, R.drawable.oppo, R.drawable.iphone};

                String[] cellphonepriceList = {"200 MYR", "250 MYR", "100 MYR", "300 MYR", "250 MYR", "200 MYR", "300 MYR"};

                for (int i = 0; i < cellphoneList.length; i++) {

                    productDomain = new ProductDomain(cellphoneList[i], cellphonepriceList[i], cellphoneimageList[i]);
                    productList.add(productDomain);
                }

                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));

                break;

            case 4:

                String[] automobilesList = {"HONDA", "HYUNDAI", "NISSAN", "FERRARI", "LAMBORGHINI"};
                int[] automobilesimageList = {R.drawable.honda, R.drawable.hyundai, R.drawable.nissan, R.drawable.ferrari, R.drawable.lamborghini};

                String[] automobilespriceList = {"200 MYR", "250 MYR", "100 MYR", "300 MYR", "250 MYR", "200 MYR", "300 MYR"};


                for (int i = 0; i < automobilesList.length; i++) {

                    productDomain = new ProductDomain(automobilesList[i], automobilespriceList[i], automobilesimageList[i]);
                    productList.add(productDomain);
                }

                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));

                break;
        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_LONG).show();
                productDetails(productList.get(i).getProductName(),productList.get(i).getProductPrice(),productList.get(i).getImageId(),i);
            }
        });


    }


    public void productDetails(String productName, String productPrice, int imgId, final int position) {
        final AlertDialog alert;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Get the layout inflater
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        //Inflate and set the layout for the dialog
        //Pass null as the parent view because its going in the dialog layout
        View view = inflater.inflate(R.layout.description_layout, null);

        builder.setView(view);
        alert = builder.create();
        alert.show();

        TextView txtProduct = view.findViewById(R.id.txt_product_name);
        TextView txtPrice = view.findViewById(R.id.txt_price);
        ImageView imageView = view.findViewById(R.id.imageView3);
        Button btnCart = view.findViewById(R.id.button);

        txtProduct.setText(productName);
        txtPrice.setText(productPrice);
        imageView.setImageResource(imgId);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //cartArray.add(productList.get(position));
                itemCount++;
                updateHotCount(itemCount);
                alert.dismiss();


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cart_menu, menu);

        final View notifications = menu.findItem(R.id.cart_item).getActionView();

        txtItemCount = (TextView) notifications.findViewById(R.id.cart_badge);
        updateHotCount(itemCount++);
        /*txtItemCount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                updateHotCount(itemCount++);
            }
        });*/

        return true;

        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item){
        //Handle item selection
            switch (item.getItemId()){
                case R.id.cart_item:
                //newGame();
                return true;

                default:
                    return super.onOptionsItemSelected(item);


            }


    }

    public void updateHotCount(final int new_number){
            itemCount = new_number;
            if (itemCount< 0) return;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (itemCount == 0)
                        txtItemCount.setVisibility(View.GONE);
                    else {
                        txtItemCount.setVisibility(View.VISIBLE);
                        txtItemCount.setText(Integer.toString(itemCount));
                        //supportInvalidateOptionsMenu();

                    }


                }
            });

    }
}

