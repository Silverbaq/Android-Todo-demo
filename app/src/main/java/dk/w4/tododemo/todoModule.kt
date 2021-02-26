package dk.w4.tododemo

import dk.w4.tododemo.repository.TodoMemoryRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val todoModule: Module = module {
    single { TodoMemoryRepository() }
    viewModel { TodoViewModel(get()) }
}