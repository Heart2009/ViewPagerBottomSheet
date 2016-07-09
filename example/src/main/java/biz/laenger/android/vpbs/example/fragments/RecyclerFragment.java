package biz.laenger.android.vpbs.example.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import biz.laenger.android.vpbs.example.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerFragment extends Fragment {

    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));
        recyclerView.setAdapter(new SimpleAdapter(getContext()));
    }

    private static class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {
        private final LayoutInflater layoutInflater;

        private SimpleAdapter(Context context) {
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder((TextView) layoutInflater.inflate(R.layout.textview, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(String.valueOf(position));
        }

        @Override
        public int getItemCount() {
            return 100;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            ViewHolder(TextView textView) {
                super(textView);
                this.textView = textView;
            }
        }
    }

}