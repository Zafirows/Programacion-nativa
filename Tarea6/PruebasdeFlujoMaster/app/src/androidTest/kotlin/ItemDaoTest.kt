package com.example.inventory

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.inventory.data.InventoryDatabase
import com.example.inventory.data.Item
import com.example.inventory.data.ItemDao
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

// Indica que esta clase usará el runner de pruebas de Android para ejecutar pruebas JUnit
@RunWith(AndroidJUnit4::class)
class ItemDaoTest {

    // Declaración de las variables necesarias
    private lateinit var itemDao: ItemDao // DAO que se va a probar
    private lateinit var inventoryDatabase: InventoryDatabase // Base de datos en memoria
    private val item1 = Item(1, "Apples", 10.0, 20) // Item de prueba 1
    private val item2 = Item(2, "Bananas", 15.0, 97) // Item de prueba 2

    // Esta función se ejecuta antes de cada prueba
    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext() // Obtiene el contexto de prueba

        // Crea una base de datos en memoria (no persistente) para pruebas
        inventoryDatabase = Room.inMemoryDatabaseBuilder(context, InventoryDatabase::class.java)
            .allowMainThreadQueries() // Permite consultas en el hilo principal solo para pruebas
            .build()

        // Obtiene el DAO de la base de datos
        itemDao = inventoryDatabase.itemDao()
    }

    // Esta función se ejecuta después de cada prueba
    @After
    @Throws(IOException::class)
    fun closeDb() {
        inventoryDatabase.close() // Cierra la base de datos
    }

    // Prueba que al insertar un ítem, este se guarda correctamente
    @Test
    @Throws(Exception::class)
    fun daoInsert_insertsItemIntoDB() = runBlocking {
        addOneItemToDb() // Inserta item1
        val allItems = itemDao.getAllItems().first() // Obtiene todos los ítems
        assertEquals(allItems[0], item1) // Verifica que el primer ítem sea igual a item1
    }

    // Prueba que se puedan recuperar múltiples ítems
    @Test
    @Throws(Exception::class)
    fun daoGetAllItems_returnsAllItemsFromDB() = runBlocking {
        addTwoItemsToDb() // Inserta item1 y item2
        val allItems = itemDao.getAllItems().first()
        assertEquals(allItems[0], item1) // Verifica el primer ítem
        assertEquals(allItems[1], item2) // Verifica el segundo ítem
    }

    // Prueba que se pueda obtener un ítem específico por ID
    @Test
    @Throws(Exception::class)
    fun daoGetItem_returnsItemFromDB() = runBlocking {
        addOneItemToDb() // Inserta item1
        val item = itemDao.getItem(1) // Recupera el ítem con ID 1
        assertEquals(item.first(), item1) // Verifica que sea igual a item1
    }

    // Prueba que se puedan eliminar ítems de la base de datos
    @Test
    @Throws(Exception::class)
    fun daoDeleteItems_deletesAllItemsFromDB() = runBlocking {
        addTwoItemsToDb() // Inserta item1 y item2
        itemDao.delete(item1) // Elimina item1
        itemDao.delete(item2) // Elimina item2
        val allItems = itemDao.getAllItems().first()
        assertTrue(allItems.isEmpty()) // Verifica que la base de datos esté vacía
    }

    // Prueba que se puedan actualizar ítems en la base de datos
    @Test
    @Throws(Exception::class)
    fun daoUpdateItems_updatesItemsInDB() = runBlocking {
        addTwoItemsToDb() // Inserta ítems originales

        // Actualiza ambos ítems con nuevos valores
        itemDao.update(Item(1, "Apples", 15.0, 25))
        itemDao.update(Item(2, "Bananas", 5.0, 50))

        val allItems = itemDao.getAllItems().first()
        // Verifica que los ítems se hayan actualizado correctamente
        assertEquals(allItems[0], Item(1, "Apples", 15.0, 25))
        assertEquals(allItems[1], Item(2, "Bananas", 5.0, 50))
    }

    // Función auxiliar para insertar solo item1
    private suspend fun addOneItemToDb() {
        itemDao.insert(item1)
    }

    // Función auxiliar para insertar item1 y item2
    private suspend fun addTwoItemsToDb() {
        itemDao.insert(item1)
        itemDao.insert(item2)
    }
}