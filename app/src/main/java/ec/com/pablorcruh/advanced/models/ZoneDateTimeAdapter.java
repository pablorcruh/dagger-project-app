package ec.com.pablorcruh.advanced.models;

import androidx.annotation.Nullable;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import org.threeten.bp.ZonedDateTime;

public class ZoneDateTimeAdapter {

    @FromJson
    ZonedDateTime fromJson(String json){
        return ZonedDateTime.parse(json);
    }

    @ToJson
    String toJson(@Nullable ZonedDateTime value){
        return value != null ? value.toString() : null;
    }
}
