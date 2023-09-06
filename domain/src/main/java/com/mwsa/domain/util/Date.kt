package com.mwsa.domain.util

import java.util.Date


fun getDate(time: Long): Date = Date(time)

fun getTimestamp(date:Date): Long = date.time