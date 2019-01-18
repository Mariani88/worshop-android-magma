package com.etermax.magma.worshop.infoplanets.infrastructure

import java.lang.RuntimeException

class BadResponse(message: String): RuntimeException(message) {
}