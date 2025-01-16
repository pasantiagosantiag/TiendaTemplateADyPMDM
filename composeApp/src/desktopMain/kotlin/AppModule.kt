import org.koin.dsl.module

val appModule = module {
    single { Repository() } // Proveer una instancia única de Repository
    factory { ViewModel(get()) } // Crear una nueva instancia de ViewModel con Repository inyectado
}

class Repository {
    fun fetchData(): String = "Datos cargados desde el repositorio"
}

class ViewModel(private val repository: Repository) {
    fun getData(): String = repository.fetchData()
}