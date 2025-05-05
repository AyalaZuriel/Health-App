package com.example.healthapp.data.local.database.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.healthapp.data.local.database.entities.SleepEntity
import com.example.healthapp.domain.model.Sleep
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun Sleep.toEntity(): SleepEntity {
    return SleepEntity(
        id = this.id,
        date = this.date.toEpochDay(),
        hours = this.hours
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun SleepEntity.toSleepItem(): Sleep {
    return Sleep(
        id = this.id,
        date = LocalDate.ofEpochDay(this.date),
        hours = hours
    )
}