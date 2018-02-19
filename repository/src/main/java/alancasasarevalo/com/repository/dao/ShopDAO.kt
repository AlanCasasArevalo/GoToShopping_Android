package alancasasarevalo.com.repository.dao

import alancasasarevalo.com.repository.DBHelper
import alancasasarevalo.com.repository.model.ShopEntity
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

internal class ShopDAO(dbHelper: DBHelper) : DAOPersistable<ShopEntity> {

    private val dbReadOnlyConnection: SQLiteDatabase = dbHelper.readableDatabase
    private val dbReadWriteConnection: SQLiteDatabase = dbHelper.writableDatabase


    override fun queryWithId(id: Long): ShopEntity {
        val cursor = queryCursor(id)
        cursor.moveToFirst()
        return entityFromCursor(cursor)!!
    }

    override fun queryListElement(): List<ShopEntity> {

        val queryResult = arrayListOf<ShopEntity>()

        val cursor = dbReadOnlyConnection.query(ShopDBConstants.TABLE_SHOP,
                ShopDBConstants.ALL_COLUMNS,
                null,
                null,
                "",
                "",
                ShopDBConstants.KEY_SHOP_DATABASE_ID)

        while (cursor.moveToNext()) {
            val shopEntity = entityFromCursor(cursor)
            queryResult.add(shopEntity!!)
        }

        return queryResult
    }

    override fun insertElement(element: ShopEntity): Long {
        var id: Long = 0

        id = dbReadWriteConnection.insert(ShopDBConstants.TABLE_SHOP, null, contentValues(element))

        return id
    }

    override fun updateElementById(id: Long, element: ShopEntity): Long {
        val numberOfRecordsUpdate = dbReadWriteConnection.update(
                ShopDBConstants.TABLE_SHOP,
                contentValues(element),
                ShopDBConstants.KEY_SHOP_DATABASE_ID + " = ?",
                arrayOf(id.toString())
        ).toLong()

        return numberOfRecordsUpdate
    }

    override fun deleteElement(element: ShopEntity): Long {
        if (element.dataBaseId < 1) {
            return 0
        }
        return deleteElementById(element.dataBaseId)
    }

    override fun deleteElementById(id: Long): Long {
        return dbReadWriteConnection.delete(ShopDBConstants.TABLE_SHOP,
                ShopDBConstants.KEY_SHOP_DATABASE_ID + " = ?",
                arrayOf(id.toString())).toLong()
    }

    override fun deleteAllElementList(): Boolean {
        return dbReadWriteConnection.delete(ShopDBConstants.TABLE_SHOP,
                null,
                null).toLong() >= 0
    }

    fun entityFromCursor(cursor: Cursor): ShopEntity? {
        if (cursor.isAfterLast || cursor.isBeforeFirst) {
            return null
        }

        return ShopEntity(
                cursor.getLong(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_DATABASE_ID)),
                cursor.getLong(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_ID_JSON)),
                cursor.getString(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_NAME)),
                cursor.getString(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_IMAGE_URL)),
                cursor.getString(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_LOGO_IMAGE_URL)),
                cursor.getString(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_ADDRESS)),
                cursor.getString(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_URL)),
                cursor.getString(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_TELEPHONE)),
                cursor.getString(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_EMAIL)),
                cursor.getString(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_SPECIAL_OFFER)),
                cursor.getString(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_DESCRIPTION_EN)),
                cursor.getString(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_LATITUDE)),
                cursor.getString(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_LONGITUDE)),
                cursor.getString(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_OPENING_HOURS_EN)),
                cursor.getString(cursor.getColumnIndex(ShopDBConstants.KEY_SHOP_KEYWORDS_EN))
        )

    }

    override fun queryCursor(id: Long): Cursor {
        val cursor = dbReadOnlyConnection.query(ShopDBConstants.TABLE_SHOP,
                ShopDBConstants.ALL_COLUMNS,
                ShopDBConstants.KEY_SHOP_DATABASE_ID + " = ?",
                arrayOf(id.toString()),
                "",
                "",
                ShopDBConstants.KEY_SHOP_DATABASE_ID
        )

        return cursor
    }

    fun contentValues(shopEntity: ShopEntity): ContentValues {
        val content = ContentValues()

        content.put(ShopDBConstants.KEY_SHOP_ID_JSON, shopEntity.id)
        content.put(ShopDBConstants.KEY_SHOP_NAME, shopEntity.name)
        content.put(ShopDBConstants.KEY_SHOP_IMAGE_URL, shopEntity.img)
        content.put(ShopDBConstants.KEY_SHOP_LOGO_IMAGE_URL, shopEntity.logoImg)
        content.put(ShopDBConstants.KEY_SHOP_ADDRESS, shopEntity.address)
        content.put(ShopDBConstants.KEY_SHOP_URL, shopEntity.url)
        content.put(ShopDBConstants.KEY_SHOP_TELEPHONE, shopEntity.telephone)
        content.put(ShopDBConstants.KEY_SHOP_EMAIL, shopEntity.email)
        content.put(ShopDBConstants.KEY_SHOP_SPECIAL_OFFER, shopEntity.specialOffer)
        content.put(ShopDBConstants.KEY_SHOP_DESCRIPTION_EN, shopEntity.description)
        content.put(ShopDBConstants.KEY_SHOP_LATITUDE, shopEntity.latitude)
        content.put(ShopDBConstants.KEY_SHOP_LONGITUDE, shopEntity.longitude)
        content.put(ShopDBConstants.KEY_SHOP_OPENING_HOURS_EN, shopEntity.openingHours)
        content.put(ShopDBConstants.KEY_SHOP_KEYWORDS_EN, shopEntity.keywords)

        return content
    }

}





























































