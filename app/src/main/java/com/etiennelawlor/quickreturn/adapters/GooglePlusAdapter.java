package com.etiennelawlor.quickreturn.adapters;

import android.content.Context;
import android.os.Handler;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.etiennelawlor.quickreturn.R;
import com.etiennelawlor.quickreturn.models.GooglePlusPost;
import com.etiennelawlor.quickreturn.utils.QuickReturnUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

//import java.util.logging.Handler;

/**
 * Created by etiennelawlor on 7/17/14.
 */
public class GooglePlusAdapter extends ArrayAdapter<GooglePlusPost> {

    // region Constants
//    private static final int INTERVAL = 5000;
    // endregion

    // region Member Variables
    private Context mContext;
    private ArrayList<GooglePlusPost> mGooglePlusPosts;
    private final LayoutInflater mInflater;
//    private int mIndicatorPosition = 0;
//    private final Handler mHandler = new Handler();
    // endregion

    // region Constructors
    public GooglePlusAdapter(Context context, ArrayList<GooglePlusPost> googlePlusPosts){
        super(context, R.layout.twitter_row, googlePlusPosts);
        mContext = context;
        mGooglePlusPosts = googlePlusPosts;

        mInflater = LayoutInflater.from(mContext);
    }
    // endregion

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.google_plus_row, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        GooglePlusPost post = getItem(position);

        holder.mDisplayNameTextView.setText(post.getDisplayName());
//        holder.mUsernameTextView.setText(tweet.getUsername());
        holder.mTimestampTextView.setText(post.getTimestamp());
//        holder.mStarTextView.setText(String.valueOf(tweet.getStarCount()));


        holder.mMessageTextView.setText(post.getMessage());
//        holder.mCommentTextView.setText(post.getCommenterOneDisplayName());

        Spanned styledText = Html.fromHtml("<b>"+post.getCommenterOneDisplayName()+"</b> "+post.getComment());
        holder.mCommentTextView.setText(styledText);
//
        Picasso.with(holder.mUserImageView.getContext())
                .load(post.getAvatarUrl())
                .centerCrop()
                .resize(QuickReturnUtils.dp2px(getContext(), 50),
                        QuickReturnUtils.dp2px(getContext(), 50))
//                    .placeholder(R.drawable.ic_facebook)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.mUserImageView);

        Picasso.with(holder.mPostImageView.getContext())
                .load(post.getPostImageUrl())
//                    .placeholder(R.drawable.ic_facebook)
                .centerCrop()
                .resize(QuickReturnUtils.dp2px(getContext(), 346),
                        QuickReturnUtils.dp2px(getContext(), 320))
                .error(android.R.drawable.stat_notify_error)
                .into(holder.mPostImageView);



        Picasso.with(holder.mCommenterOneImageView.getContext())
                .load(post.getCommenterOneAvatarUrl())
                .centerCrop()
                .resize(QuickReturnUtils.dp2px(getContext(), 34),
                        QuickReturnUtils.dp2px(getContext(), 34))
//                    .placeholder(R.drawable.ic_facebook)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.mCommenterOneImageView);

        Picasso.with(holder.mCommenterTwoImageView.getContext())
                .load(post.getCommenterTwoAvatarUrl())
                .centerCrop()
                .resize(QuickReturnUtils.dp2px(getContext(), 34),
                        QuickReturnUtils.dp2px(getContext(), 34))
//                    .placeholder(R.drawable.ic_facebook)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.mCommenterTwoImageView);

        Picasso.with(holder.mCommenterThreeImageView.getContext())
                .load(post.getCommenterThreeAvatarUrl())
                .centerCrop()
                .resize(QuickReturnUtils.dp2px(getContext(), 34),
                        QuickReturnUtils.dp2px(getContext(), 34))
//                    .placeholder(R.drawable.ic_facebook)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.mCommenterThreeImageView);

//        holder.mRunnable = new Runnable() {
//            @Override
//            public void run() {
//
//                TranslateAnimation ta;
//
//                switch (mIndicatorPosition){
//                    case 0:
//                        ta = new TranslateAnimation(holder.mIndicatorView.getX(),
//                                holder.mIndicatorView.getX() + (QuickReturnUtils.dp2px(getContext(),37)) , 0, 0);
//                        ta.setDuration(500);
//                        ta.setFillAfter(true);
//                        holder.mIndicatorView.startAnimation(ta);
//                        mIndicatorPosition = 1;
//                        break;
//                    case 1:
//                        ta = new TranslateAnimation(holder.mIndicatorView.getX() + (QuickReturnUtils.dp2px(getContext(),37)),
//                                holder.mIndicatorView.getX() + (QuickReturnUtils.dp2px(getContext(),75)) , 0, 0);
//                        ta.setDuration(500);
//                        ta.setFillAfter(true);
//                        holder.mIndicatorView.startAnimation(ta);
//                        mIndicatorPosition = 2;
//                        break;
//                    case 2:
//                        ta = new TranslateAnimation(holder.mIndicatorView.getX() + (QuickReturnUtils.dp2px(getContext(),75)),
//                                holder.mIndicatorView.getX() , 0, 0);
//                        ta.setDuration(500);
//                        ta.setFillAfter(true);
//                        holder.mIndicatorView.startAnimation(ta);
//                        mIndicatorPosition = 0;
//                        break;
//                }
//
//                mHandler.postDelayed(holder.mRunnable, INTERVAL);
//            }
//        };
//
//        mHandler.removeCallbacks(holder.mRunnable);
//        mHandler.post(holder.mRunnable);

        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.user_iv) ImageView mUserImageView;
        @InjectView(R.id.display_name_tv) TextView mDisplayNameTextView;
//        @InjectView(R.id.username_tv) TextView mUsernameTextView;
        @InjectView(R.id.comment_tv) TextView mCommentTextView;
        @InjectView(R.id.timestamp_tv) TextView mTimestampTextView;
        @InjectView(R.id.message_tv) TextView mMessageTextView;
        @InjectView(R.id.post_iv) ImageView mPostImageView;
        @InjectView(R.id.commenter_one_iv) ImageView mCommenterOneImageView;
        @InjectView(R.id.commenter_two_iv) ImageView mCommenterTwoImageView;
        @InjectView(R.id.commenter_three_iv) ImageView mCommenterThreeImageView;
        @InjectView(R.id.indicator_v) View mIndicatorView;




//        Runnable mRunnable;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }


}