package com.pdmcourse2026.RankeUca

import android.app.Application
import com.pdmcourse2026.RankeUca.data.AppProvider

class RankeUcaApplication : Application() {
    val appProvider by lazy { AppProvider(this) }
}