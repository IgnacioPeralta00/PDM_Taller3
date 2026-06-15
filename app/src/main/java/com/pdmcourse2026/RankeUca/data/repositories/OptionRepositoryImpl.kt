package com.pdmcourse2026.RankeUca.data.repositories

import com.pdmcourse2026.RankeUca.data.local.dao.OptionDao
import com.pdmcourse2026.RankeUca.data.local.mapper.toEntity
import com.pdmcourse2026.RankeUca.data.local.mapper.toModel
import com.pdmcourse2026.RankeUca.data.remote.KtorClient
import com.pdmcourse2026.RankeUca.data.remote.dto.OptionDto
import com.pdmcourse2026.RankeUca.data.remote.dto.PostRequestDto
import com.pdmcourse2026.RankeUca.data.remote.dto.PostResponseDto
import com.pdmcourse2026.RankeUca.data.remote.dto.toModel
import com.pdmcourse2026.RankeUca.domain.models.Option
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OptionRepositoryImpl(
    private val optionDao: OptionDao
) : OptionRepository {
    override suspend fun getPlaces(): Result<List<Option>> {
        try {
            val response : List<OptionDto> = KtorClient.client.get("options").body()
            return Result.success(response.map { placeDto -> placeDto.toModel() })
        }
        catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun votePlace(placeId: Int): Result<Boolean> {
        try {
            val request = PostRequestDto(
                optionId = placeId
            )
            val response : PostResponseDto = KtorClient.client.post("vote") {
                setBody(request)
            }.body()
            return Result.success(response.ok)
        }
        catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override fun getOptions(questionId: Int): Flow<List<Option>> {
        return optionDao.getOptionsForQuestion(questionId).map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun addOption(name: String, imageUrl: String, questionId: Int) {
        val option = Option(name = name, imageUrl = imageUrl, questionId = questionId)
        optionDao.insertOption(option.toEntity())
    }

    override suspend fun deleteOption(option: Option) {
        optionDao.deleteOption(option.toEntity())
    }

}

