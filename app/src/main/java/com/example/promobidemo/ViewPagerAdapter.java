package com.example.promobidemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Objects;

public class ViewPagerAdapter extends PagerAdapter {

    Context mCtx;
    List<Cat> catList;
    LayoutInflater inflater;

    public ViewPagerAdapter(Context context, List<Cat> catList){
        this.mCtx = context;
        this.catList = catList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
//        return catList.size();
        return 67;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.recyclerview_layout,container,false);
        ImageView imageView;
        TextView catName,catOrigin,description,vcahospitals_url,vetstreet_url,cfa_url,temperament,alt_names,life_span,wikipedia_url;
        RatingBar adaptability,affection_level,child_friendly,dog_friendly,energy_level,grooming,health_issues,intelligence,shedding_level,social_needs
                ,stranger_friendly,vocalisation,experimental;
        imageView = view.findViewById(R.id.cat_image);
        catName = view.findViewById(R.id.cat_name);
        catOrigin = view.findViewById(R.id.cat_origin);
//            vcahospitals_url = itemView.findViewById(R.id.vcahospitals_url);
//            vetstreet_url = itemView.findViewById(R.id.vetstreet_url);
//            cfa_url = itemView.findViewById(R.id.cfa_url);
        description = view.findViewById(R.id.description);
        temperament = view.findViewById(R.id.temperament);
        alt_names = view.findViewById(R.id.alt_names);
        life_span = view.findViewById(R.id.life_span);
        adaptability = view.findViewById(R.id.adaptability);
        affection_level = view.findViewById(R.id.affection_level);
        child_friendly = view.findViewById(R.id.child_friendly);
        dog_friendly = view.findViewById(R.id.dog_friendly);
        energy_level = view.findViewById(R.id.energy_level);
        grooming = view.findViewById(R.id.grooming);
        health_issues = view.findViewById(R.id.health_issues);
        intelligence = view.findViewById(R.id.intelligence);
        shedding_level = view.findViewById(R.id.shedding_level);
        social_needs = view.findViewById(R.id.social_needs);
        stranger_friendly = view.findViewById(R.id.stranger_friendly);
        vocalisation = view.findViewById(R.id.vocalisation);
        experimental = view.findViewById(R.id.experimental);
        wikipedia_url = view.findViewById(R.id.wikipedia_url);

        Cat cat = catList.get(position);
        catName.setText(cat.getName());
        catOrigin.setText(cat.getOrigin());
        if (catList.get(position).getImage()== null || catList.get(position).getImage().getUrl()==null){

            imageView.setImageResource(R.drawable.no_image_available);
        }
        else {
            Glide.with(mCtx)
                    .load(catList.get(position).getImage().getUrl())
                    .into(imageView);
        }
//            holder.cfa_url.setText(cat.getCfa_url());
//            holder.vetstreet_url.setText(cat.getVetstreet_url());
//            holder.vcahospitals_url.setText(cat.getVcahospitals_url());
        description.setText(cat.getDescription());
        temperament.setText(cat.getTemperament());
        if (catList.get(position).getAlt_names()==null){
            alt_names.setText("-");
        }else {
            alt_names.setText(cat.getAlt_names());
        }
        life_span.setText(cat.getLife_span());
        adaptability.setRating(cat.getAdaptability());
        affection_level.setRating(cat.getAffection_level());
        child_friendly.setRating(cat.getChild_friendly());
        dog_friendly.setRating(cat.getDog_friendly());
        energy_level.setRating(cat.getEnergy_level());
        grooming.setRating(cat.getGrooming());
        health_issues.setRating(cat.getHealth_issues());
        intelligence.setRating(cat.getIntelligence());
        shedding_level.setRating(cat.getShedding_level());
        social_needs.setRating(cat.getSocial_needs());
        stranger_friendly.setRating(cat.getStranger_friendly());
        vocalisation.setRating(cat.getVocalisation());
        experimental.setRating(cat.getExperimental());
        wikipedia_url.setText(cat.getWikipedia_url());

        Objects.requireNonNull(container).addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
