package layout;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miika.myapplication.MainActivity;
import com.example.miika.myapplication.R;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

/**
 * Implementation of App Widget functionality.
 */
public class MyAppWidgetActivity extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_app_widget_activity);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);

        Log.w("test", "updateAppWidget");

    }

    public void updateText(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        Log.w("test", "button pressed!");

        CharSequence widgetText = context.getString(R.string.color_changed);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_app_widget_activity);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        Log.w("test", "On update!");


//        Socket socket = null;
//
//        try {
//            socket = IO.socket("http://http://ec2-52-209-142-0.eu-west-1.compute.amazonaws.com:3000/");
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
//
//            @Override
//            public void call(Object... args) {
//                Log.w("test", "Connection created!");
//                //socket.emit("foo", "hi");
//                //socket.disconnect();
//            }
//
//        }).on("message", new Emitter.Listener() {
//
//            @Override
//            public void call(Object... args) {
//                Log.w("test", "Message arrived!");
//                Log.w("test", (String) args[0]);
//            }
//
//        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
//
//            @Override
//            public void call(Object... args) {}
//
//        });
//        socket.connect();

        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        Log.w("test", "On Enabled!");
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        Log.w("test", "On Disabled!");
        // Enter relevant functionality for when the last widget is disabled
    }
}

