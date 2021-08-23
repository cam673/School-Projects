package com.example.homework2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryDropdownMenu extends PopupWindow {
    /*private Context context;
    private RecyclerView popCategory;
    private CategoryDropdownAdapter dropdownAdapter;

    public CategoryDropdownMenu(Context context) {
        super(context);
        this.context = context;
        setupView();
    }

    public void setCategorySelectedListener(CategoryDropdownAdapter.CategorySelectedListener categorySelectedListener) {
        dropdownAdapter.setCategorySelectedListener(categorySelectedListener);
    }

    private void setupView() {
        View view = LayoutInflater.from(context).inflate(R.layout.popup_category, null);

        popCategory = view.findViewById(R.id.popCategory);
        popCategory.setHasFixedSize(true);
        popCategory.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        popCategory.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));

        dropdownAdapter = new CategoryDropdownAdapter(Category.generateCategoryList());
        popCategory.setAdapter(dropdownAdapter);

        setContentView(view);
    }*/

}