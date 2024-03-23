package com.candybar.sample.applications;

import androidx.annotation.NonNull;

// TODO: Remove `//` below to enable OneSignal
//import com.onesignal.OneSignal;

import com.candybar.sample.R;
import com.posthog.android.PostHogAndroid;
import com.posthog.android.PostHogAndroidConfig;
import com.posthog.android.replay.PostHogSessionReplayConfig;

import candybar.lib.applications.CandyBarApplication;

public class CandyBar extends CandyBarApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        PostHogSessionReplayConfig sessionReplayConfig = new PostHogSessionReplayConfig(
                false, false, true, null
        );

        PostHogAndroidConfig config = new PostHogAndroidConfig(
                "phc_pQ70jJhZKHRvDIL5ruOErnPy6xiAiWCqlL4ayELj4X8",
                "https://app.posthog.com",
                true,
                true,
                true,
                sessionReplayConfig
        );
        config.setDebug(true);
        config.setSessionReplay(true);
        PostHogAndroid.Companion.setup(this, config);
    }

    @NonNull
    @Override
    public Class<?> getDrawableClass() {
        return R.drawable.class;
    }

    @NonNull
    @Override
    public Configuration onInit() {
        // Sample configuration
        Configuration configuration = new Configuration();

        configuration.setGenerateAppFilter(true);
        configuration.setGenerateAppMap(true);
        configuration.setGenerateThemeResources(true);

        return configuration;
    }
}
