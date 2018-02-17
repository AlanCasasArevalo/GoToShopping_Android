package alancasasarevalo.com.repository.dao

import alancasasarevalo.com.repository.DBHelper
import alancasasarevalo.com.repository.model.ActivityEntity
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

internal class ActivityDAO(dbHelper: DBHelper) : DAOPersistable<ActivityEntity> {

    private val dbReadOnlyConnection: SQLiteDatabase = dbHelper.readableDatabase
    private val dbReadWriteConnection: SQLiteDatabase = dbHelper.writableDatabase


    override fun queryWithId(id: Long): ActivityEntity {
        val cursor = queryCursor(id)
        cursor.moveToFirst()
        return entityFromCursor(cursor)!!
    }

    override fun queryListElement(): List<ActivityEntity> {

        val queryResult = arrayListOf<ActivityEntity>()

        val cursor = dbReadOnlyConnection.query(ActivityDBConstants.TABLE_ACTIVITY,
                ActivityDBConstants.ALL_COLUMNS,
                null,
                null,
                "",
                "",
                ActivityDBConstants.KEY_ACTIVITY_DATABASE_ID)

        while (cursor.moveToNext()) {
            val activityEntity = entityFromCursor(cursor)
            queryResult.add(activityEntity!!)
        }

        return queryResult
    }

    override fun insertElement(element: ActivityEntity): Long {
        var id: Long = 0

        id = dbReadWriteConnection.insert(ActivityDBConstants.TABLE_ACTIVITY, null, contentValues(element))

        return id
    }

    override fun updateElementById(id: Long, element: ActivityEntity): Long {
        val numberOfRecordsUpdate = dbReadWriteConnection.update(
                ActivityDBConstants.TABLE_ACTIVITY,
                contentValues(element),
                ActivityDBConstants.KEY_ACTIVITY_DATABASE_ID + " = ?",
                arrayOf(id.toString())
        ).toLong()

        return numberOfRecordsUpdate
    }

    override fun deleteElement(element: ActivityEntity): Long {
        if (element.dataBaseId < 1) {
            return 0
        }
        return deleteElementById(element.dataBaseId)
    }

    override fun deleteElementById(id: Long): Long {
        return dbReadWriteConnection.delete(ActivityDBConstants.TABLE_ACTIVITY,
                ActivityDBConstants.KEY_ACTIVITY_DATABASE_ID + " = ?",
                arrayOf(id.toString())).toLong()
    }

    override fun deleteAllElementList(): Boolean {
        return dbReadWriteConnection.delete(ActivityDBConstants.TABLE_ACTIVITY,
                null,
                null).toLong() >= 0
    }

    fun entityFromCursor(cursor: Cursor): ActivityEntity? {
        if (cursor.isAfterLast || cursor.isBeforeFirst) {
            return null
        }

        return ActivityEntity(
                cursor.getLong(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_DATABASE_ID)),
                cursor.getLong(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_ID_JSON)),
                cursor.getString(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_NAME)),
                cursor.getString(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_IMAGE_URL)),
                cursor.getString(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_LOGO_IMAGE_URL)),
                cursor.getString(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_ADDRESS)),
                cursor.getString(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_URL)),
                cursor.getString(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_TELEPHONE)),
                cursor.getString(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_EMAIL)),
                cursor.getString(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_SPECIAL_OFFER)),
                cursor.getString(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_DESCRIPTION_EN)),
                cursor.getString(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_LATITUDE)),
                cursor.getString(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_LONGITUDE)),
                cursor.getString(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_OPENING_HOURS_EN)),
                cursor.getString(cursor.getColumnIndex(ActivityDBConstants.KEY_ACTIVITY_KEYWORDS_EN))
        )

    }

    override fun queryCursor(id: Long): Cursor {
        val cursor = dbReadOnlyConnection.query(ActivityDBConstants.TABLE_ACTIVITY,
                ActivityDBConstants.ALL_COLUMNS,
                ActivityDBConstants.KEY_ACTIVITY_DATABASE_ID + " = ?",
                arrayOf(id.toString()),
                "",
                "",
                ActivityDBConstants.KEY_ACTIVITY_DATABASE_ID
        )

        return cursor
    }

    fun contentValues(activityEntity: ActivityEntity): ContentValues {
        val content = ContentValues()

        content.put(ActivityDBConstants.KEY_ACTIVITY_ID_JSON, activityEntity.id)
        content.put(ActivityDBConstants.KEY_ACTIVITY_NAME, activityEntity.name)
        content.put(ActivityDBConstants.KEY_ACTIVITY_IMAGE_URL, activityEntity.img)
        content.put(ActivityDBConstants.KEY_ACTIVITY_LOGO_IMAGE_URL, activityEntity.logo)
        content.put(ActivityDBConstants.KEY_ACTIVITY_ADDRESS, activityEntity.address)
        content.put(ActivityDBConstants.KEY_ACTIVITY_URL, activityEntity.url)
        content.put(ActivityDBConstants.KEY_ACTIVITY_TELEPHONE, activityEntity.telephone)
        content.put(ActivityDBConstants.KEY_ACTIVITY_EMAIL, activityEntity.email)
        content.put(ActivityDBConstants.KEY_ACTIVITY_SPECIAL_OFFER, activityEntity.specialOffer)
        content.put(ActivityDBConstants.KEY_ACTIVITY_DESCRIPTION_EN, activityEntity.description_en)
        content.put(ActivityDBConstants.KEY_ACTIVITY_LATITUDE, activityEntity.latitude)
        content.put(ActivityDBConstants.KEY_ACTIVITY_LONGITUDE, activityEntity.longitude)
        content.put(ActivityDBConstants.KEY_ACTIVITY_OPENING_HOURS_EN, activityEntity.opening_hours_en)
        content.put(ActivityDBConstants.KEY_ACTIVITY_KEYWORDS_EN, activityEntity.keywordsEn)

        return content
    }

}


