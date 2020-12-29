package com.example.promobidemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class CatsAdapter extends RecyclerView.Adapter<CatsAdapter.CatViewHolder> {
    Context mCtx;
    List<Cat> catList;

    public CatsAdapter(Context context, List<Cat> catList){
        this.mCtx = context;
        this.catList = catList;
    }
    @NonNull
    @Override
    public CatsAdapter.CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout,parent,false);
        return new CatViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CatsAdapter.CatViewHolder holder, int position) {
        Cat cat = catList.get(position);
        holder.catName.setText(cat.getName());
           holder.catOrigin.setText(cat.getOrigin());
            if (catList.get(position).getImage()== null || catList.get(position).getImage().getUrl()==null){

                holder.imageView.setImageResource(R.drawable.no_image_available);
            }
            else {
                Glide.with(mCtx)
                        .load(catList.get(position).getImage().getUrl())
                        .into(holder.imageView);
            }
//            holder.cfa_url.setText(cat.getCfa_url());
//            holder.vetstreet_url.setText(cat.getVetstreet_url());
//            holder.vcahospitals_url.setText(cat.getVcahospitals_url());
           holder.description.setText(cat.getDescription());
           holder.temperament.setText(cat.getTemperament());
           if (catList.get(position).getAlt_names()==null){
               holder.alt_names.setText("-");
           }else {
               holder.alt_names.setText(cat.getAlt_names());
           }
           holder.life_span.setText(cat.getLife_span());
           holder.adaptability.setRating(cat.getAdaptability());
           holder.affection_level.setRating(cat.getAffection_level());
           holder.child_friendly.setRating(cat.getChild_friendly());
           holder.dog_friendly.setRating(cat.getDog_friendly());
           holder.energy_level.setRating(cat.getEnergy_level());
           holder.grooming.setRating(cat.getGrooming());
           holder.health_issues.setRating(cat.getHealth_issues());
           holder.intelligence.setRating(cat.getIntelligence());
           holder.shedding_level.setRating(cat.getShedding_level());
           holder.social_needs.setRating(cat.getSocial_needs());
           holder.stranger_friendly.setRating(cat.getStranger_friendly());
           holder.vocalisation.setRating(cat.getVocalisation());
           holder.experimental.setRating(cat.getExperimental());
           holder.wikipedia_url.setText(cat.getWikipedia_url());

    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    public static class CatViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView catName,catOrigin,description,vcahospitals_url,vetstreet_url,cfa_url,temperament,alt_names,life_span,wikipedia_url;
        RatingBar adaptability,affection_level,child_friendly,dog_friendly,energy_level,grooming,health_issues,intelligence,shedding_level,social_needs
                ,stranger_friendly,vocalisation,experimental;
        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cat_image);
            catName = itemView.findViewById(R.id.cat_name);
            catOrigin = itemView.findViewById(R.id.cat_origin);
//            vcahospitals_url = itemView.findViewById(R.id.vcahospitals_url);
//            vetstreet_url = itemView.findViewById(R.id.vetstreet_url);
//            cfa_url = itemView.findViewById(R.id.cfa_url);
            description = itemView.findViewById(R.id.description);
            temperament = itemView.findViewById(R.id.temperament);
            alt_names = itemView.findViewById(R.id.alt_names);
            life_span = itemView.findViewById(R.id.life_span);
            adaptability = itemView.findViewById(R.id.adaptability);
            affection_level = itemView.findViewById(R.id.affection_level);
            child_friendly = itemView.findViewById(R.id.child_friendly);
            dog_friendly = itemView.findViewById(R.id.dog_friendly);
            energy_level = itemView.findViewById(R.id.energy_level);
            grooming = itemView.findViewById(R.id.grooming);
            health_issues = itemView.findViewById(R.id.health_issues);
            intelligence = itemView.findViewById(R.id.intelligence);
            shedding_level = itemView.findViewById(R.id.shedding_level);
            social_needs = itemView.findViewById(R.id.social_needs);
            stranger_friendly = itemView.findViewById(R.id.stranger_friendly);
            vocalisation = itemView.findViewById(R.id.vocalisation);
            experimental = itemView.findViewById(R.id.experimental);
            wikipedia_url = itemView.findViewById(R.id.wikipedia_url);
        }
    }
}
