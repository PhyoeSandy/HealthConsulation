package com.padc.shared.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.padc.shared.data.vos.*
import com.padc.shared.persistence.daos.*
import com.padc.shared.persistence.typeconverters.*

@Database(
    entities = [DoctorVO::class, PatientVO::class,
        //AddressVO::class, CaseSummaryVO::class,  CheckoutVO::class,
        //MedicineVO::class, RoutineVO::class, TreatmentRecordVO::class,
        ConsulationVO::class, ConsulationRequestVO::class, SpecialityVO::class,ChatVO::class,
        GeneralQuesVO::class, SpecialQuesVO::class, ShortQuesVO::class], version = 5, exportSchema = false
)
@TypeConverters(
    SenderTypeConverter::class,
    SpecialQuesListTypeConverter::class, ShortQuesListTypeConverter::class,
    CasesummaryListTypeConverter::class, AddressListTypeConverter::class,
    MedicinesListTypeConverter::class, RecentlyDocListTypeConverter::class,
    QuestionsListTypeConverter::class, DoctorTypeConverter::class, ChatListTypeConverter::class,
    PatientTypeConverter::class, TreatmentRecordTypeConverter::class)
abstract class HealthCareDB : RoomDatabase() {
    companion object {
        val DB_NAME = "HealthCare.DB"
        var dbInstance: HealthCareDB? = null

        fun getDBInstance(context: Context): HealthCareDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, HealthCareDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }

    abstract fun specialityDao(): SpecialityDao
    abstract fun consulationDao(): ConsulationDao
    abstract fun patientDao(): PatientDao
    abstract fun doctorDao(): DoctorDao
    abstract fun generalQuesDao(): GeneralQuesDao
    abstract fun specialQuesDao(): SpeciallQuesDao
    abstract fun shortQuesDao(): ShortQuesDao
}