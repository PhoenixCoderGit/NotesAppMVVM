package com.felixmamaniquispe.notesappmvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.felixmamaniquispe.notesappmvvm.database.room.AppRoomDatabase
import com.felixmamaniquispe.notesappmvvm.database.room.repository.RoomRepository
import com.felixmamaniquispe.notesappmvvm.model.Note
import com.felixmamaniquispe.notesappmvvm.utils.REPOSITORY
import com.felixmamaniquispe.notesappmvvm.utils.TYPE_FIREBASE
import com.felixmamaniquispe.notesappmvvm.utils.TYPE_ROOM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MainViewModel(application: Application): AndroidViewModel(application) {

    /*val readTest: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }

    val dbType: MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM)
    }

    init {
        readTest.value =
            when(dbType.value) {
                TYPE_ROOM -> {
                    listOf<Note>(
                        Note(title = "Note 1", subtitle = "subtitulo 1"),
                        Note(title = "Note 2", subtitle = "subtitulo 2"),
                        Note(title = "Note 3", subtitle = "subtitulo 3")
                    )
                }
                TYPE_FIREBASE -> listOf()
                else -> listOf()
            }
    }*/

    val context = application

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        //dbType.value = type
        Log.d("checkData", "MainViewModel initDatabase $type")
        when(type){
            TYPE_ROOM -> {

                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()

            }
        }
    }

    fun addNote(note: Note, onSuccess: () -> Unit){
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.create(note=note){
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun updateNote(note:Note, onSuccess: () -> Unit){
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.update(note = note){
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllNotes() = REPOSITORY.readAll

}

class MainViewModelFactory(private val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknow viewModel class")
    }
}