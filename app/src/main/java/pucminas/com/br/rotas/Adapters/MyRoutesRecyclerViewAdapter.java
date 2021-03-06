package pucminas.com.br.rotas.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import pucminas.com.br.rotas.R;
import pucminas.com.br.rotas.fragments.RoutesFragment.OnListFragmentInteractionListener;
import pucminas.com.br.rotas.route.RouteItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link RouteItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class MyRoutesRecyclerViewAdapter extends RecyclerView.Adapter<MyRoutesRecyclerViewAdapter.ViewHolder> {

    private final List<RouteItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyRoutesRecyclerViewAdapter(List<RouteItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    public List<RouteItem> getValues() {
        return mValues;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_routes, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(String.valueOf(position));
        holder.mContentView.setText(mValues.get(position).id);


        holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                mListener.onListFragmentInteraction(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public RouteItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.id);
            mContentView = view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
