package br.com.ericandrade.hearthstoneapi.di

import br.com.ericandrade.hearthstoneapi.repository.remote.HearthStoneRepository
import br.com.ericandrade.hearthstoneapi.repository.remote.service.HeartStoneService
import br.com.ericandrade.hearthstoneapi.repository.remote.settings.ApiConnection
import br.com.ericandrade.hearthstoneapi.repository.remote.settings.interceptor.HeaderInterceptor
import br.com.ericandrade.hearthstoneapi.ui.cards.viewModel.CardsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val apiConnectionModule = module {
    factory { ApiConnection() }
    factory { HeaderInterceptor() }
}

val viewModelModule = module {
    viewModel { CardsViewModel(get()) }
}

val repositoryModule = module {
    single { HearthStoneRepository(get()) }
}

val serviceModule = module {
    single { HeartStoneService(get()) }
}
