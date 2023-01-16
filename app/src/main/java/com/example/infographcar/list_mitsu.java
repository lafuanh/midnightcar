package com.example.infographcar;

import android.content.res.AssetManager;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link list_mitsu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class list_mitsu extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public list_mitsu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment list_mitsu.
     */
    // TODO: Rename and change types and number of parameters
    public static list_mitsu newInstance(String param1, String param2) {
        list_mitsu fragment = new list_mitsu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_mitsu, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(new CarAdapter(getActivity(), cars));
//Read the json file from assets
        String json = null;
        AssetManager am = getContext().getAssets();

        try {
            InputStream is = am.open("carlist.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }


    public static class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {
        private final List<Car> mCars;

        public CarAdapter(List<Car> cars) {
            mCars = cars;
        }

        @Override
        public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_car, parent, false);
            return new CarViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CarAdapter.CarViewHolder holder, int position) {

        }

        @Override
        public void onBindViewHolder(CarViewHolder holder, int position) {
            Car car = mCars.get(position);
            holder.bindCar(car);
        }

        @Override
        public int getItemCount() {
            return mCars.size();
        }
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder {
        final TextView mNameTextView;
        final TextView mYearTextView;
        final TextView mCostTextView;
        final TextView mSpeedTextView;
        final TextView mTopSpeedTextView;
        final ImageView mCarImageView;

        public CarViewHolder(View itemView) {
            super(itemView);
            mCarImageView = itemView.findViewById(R.id.car_image);
            mNameTextView = itemView.findViewById(R.id.car_name);
            mYearTextView = itemView.findViewById(R.id.car_year);
            mCostTextView = itemView.findViewById(R.id.car_cost);
            mSpeedTextView = itemView.findViewById(R.id.car_speed);
            mTopSpeedTextView = itemView.findViewById(R.id.car_top_speed);
        }

        public void bind(final Car car) {
            mNameTextView.setText(car.getName());
            mYearTextView.setText(car.getYear());
            mCostTextView.setText(car.getCostInYen());
            mSpeedTextView.setText(car.get0_100_kmh_speed_in_time());
            mTopSpeedTextView.setText(car.getTopSpeed());
            Picasso.get().load(car.getImageLink()).into(mCarImageView);
        }
    }

}


