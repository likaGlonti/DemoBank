package com.example.domain.models.exception

import java.lang.Exception

class PersonalIdNotValidException : Exception("Id is not digit or the length is not 11")