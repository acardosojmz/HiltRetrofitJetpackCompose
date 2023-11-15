package dev.cardoso.test.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.cardoso.test.domain.repositories.QuoteRepository
import dev.cardoso.test.model.QuoteModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val repository: QuoteRepository
): ViewModel(){

    val quotes : MutableLiveData<List<QuoteModel>> = MutableLiveData()

    private val _serverIP = mutableStateOf("")
    val serverIP: State<String> = _serverIP


    fun getQuotes(){
        viewModelScope.launch {
            quotes.value = repository.getQuotes()
            Log.e("ERROR: ", quotes.value.toString())
        }
    }
    fun refreshIP(ip: String){
           _serverIP.value = ip
    }

}
