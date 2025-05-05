package com.example.healthapp.data.local.database.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.healthapp.data.local.database.entities.StepEntity
import com.example.healthapp.domain.model.Step
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
fun Step.toEntity(): StepEntity {
    return StepEntity(
        id = this.id,
        date = this.date.toEpochDay(),
        stepCount = stepCount
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun StepEntity.toStepItem(): Step {
    return Step(
        id = this.id,
        date = LocalDate.ofEpochDay(this.date),
        stepCount = this.stepCount
    )
}