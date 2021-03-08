package fr.umontpellier.persistenceexercice3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

class MainActivity2Utilisation  implements LifecycleObserver {
   public static int count  = 0;

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public int nombreDutilisation(){
        ++count;
        return count;
    }
}