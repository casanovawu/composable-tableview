package com.sunnychung.lib.android.composabletable.demo.repository

import com.sunnychung.lib.android.composabletable.demo.model.TransitConnect
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class RouteSearchHttpRepository {
    protected val jsonMapper = Json { ignoreUnknownKeys = true }

    fun searchRoutes(): List<TransitConnect> {
        // dummy data
        val json = "[{\"summary\":{\"startAt\":\"2023-06-29T14:18:00+09:00\",\"endAt\":\"2023-06-29T18:37:00+09:00\",\"fares\":{\"Bus\":{\"unit\":\"¥\",\"amount\":560},\"JR\":{\"unit\":\"¥\",\"amount\":11590},\"Subway\":{\"unit\":\"¥\",\"amount\":260}},\"totalFare\":{\"unit\":\"¥\",\"amount\":12410},\"walkingSeconds\":1320,\"waitingSeconds\":4860,\"numOfTrips\":4},\"keyStops\":[{\"name\":\"丸尾\"},{\"name\":\"霧島神宮駅/霧島神宮\"},{\"name\":\"鹿児島中央\"},{\"name\":\"博多\"},{\"name\":\"福岡空港\"}]},{\"summary\":{\"startAt\":\"2023-06-29T14:18:00+09:00\",\"endAt\":\"2023-06-29T19:04:00+09:00\",\"fares\":{\"Bus\":{\"unit\":\"¥\",\"amount\":560},\"JR\":{\"unit\":\"¥\",\"amount\":11590},\"Subway\":{\"unit\":\"¥\",\"amount\":260}},\"totalFare\":{\"unit\":\"¥\",\"amount\":12410},\"walkingSeconds\":1320,\"waitingSeconds\":5280,\"numOfTrips\":4},\"keyStops\":[{\"name\":\"丸尾\"},{\"name\":\"霧島神宮駅/霧島神宮\"},{\"name\":\"鹿児島中央\"},{\"name\":\"博多\"},{\"name\":\"福岡空港\"}]},{\"summary\":{\"startAt\":\"2023-06-29T14:18:00+09:00\",\"endAt\":\"2023-06-29T19:34:00+09:00\",\"fares\":{\"Bus\":{\"unit\":\"¥\",\"amount\":560},\"JR\":{\"unit\":\"¥\",\"amount\":10990},\"Subway\":{\"unit\":\"¥\",\"amount\":260}},\"totalFare\":{\"unit\":\"¥\",\"amount\":11810},\"walkingSeconds\":1320,\"waitingSeconds\":7140,\"numOfTrips\":4},\"keyStops\":[{\"name\":\"丸尾\"},{\"name\":\"霧島神宮駅/霧島神宮\"},{\"name\":\"鹿児島 ≪降車不要≫\"},{\"name\":\"鹿児島中央\"},{\"name\":\"博多\"},{\"name\":\"福岡空港\"}]},{\"summary\":{\"startAt\":\"2023-06-29T14:27:00+09:00\",\"endAt\":\"2023-06-29T19:34:00+09:00\",\"fares\":{\"Bus\":{\"unit\":\"¥\",\"amount\":2360},\"JR\":{\"unit\":\"¥\",\"amount\":9040},\"Subway\":{\"unit\":\"¥\",\"amount\":260}},\"totalFare\":{\"unit\":\"¥\",\"amount\":11660},\"walkingSeconds\":1260,\"waitingSeconds\":6120,\"numOfTrips\":5},\"keyStops\":[{\"name\":\"丸尾\"},{\"name\":\"丸尾\"},{\"name\":\"鹿児島空港\"},{\"name\":\"川内駅前/川内（鹿児島）\"},{\"name\":\"博多\"},{\"name\":\"福岡空港\"}]},{\"summary\":{\"startAt\":\"2023-06-29T14:18:00+09:00\",\"endAt\":\"2023-06-29T19:34:00+09:00\",\"fares\":{\"Bus\":{\"unit\":\"¥\",\"amount\":940},\"JR\":{\"unit\":\"¥\",\"amount\":10990},\"Subway\":{\"unit\":\"¥\",\"amount\":260}},\"totalFare\":{\"unit\":\"¥\",\"amount\":12190},\"walkingSeconds\":1260,\"waitingSeconds\":6420,\"numOfTrips\":4},\"keyStops\":[{\"name\":\"丸尾\"},{\"name\":\"国分駅/国分（鹿児島）\"},{\"name\":\"鹿児島 ≪降車不要≫\"},{\"name\":\"鹿児島中央\"},{\"name\":\"博多\"},{\"name\":\"福岡空港\"}]},{\"summary\":{\"startAt\":\"2023-06-29T14:18:00+09:00\",\"endAt\":\"2023-06-29T19:58:00+09:00\",\"fares\":{\"Bus\":{\"unit\":\"¥\",\"amount\":560},\"JR\":{\"unit\":\"¥\",\"amount\":10990},\"Subway\":{\"unit\":\"¥\",\"amount\":260}},\"totalFare\":{\"unit\":\"¥\",\"amount\":11810},\"walkingSeconds\":1320,\"waitingSeconds\":7680,\"numOfTrips\":4},\"keyStops\":[{\"name\":\"丸尾\"},{\"name\":\"霧島神宮駅/霧島神宮\"},{\"name\":\"鹿児島 ≪降車不要≫\"},{\"name\":\"鹿児島中央\"},{\"name\":\"博多\"},{\"name\":\"福岡空港\"}]},{\"summary\":{\"startAt\":\"2023-06-29T14:18:00+09:00\",\"endAt\":\"2023-06-29T19:58:00+09:00\",\"fares\":{\"Bus\":{\"unit\":\"¥\",\"amount\":940},\"JR\":{\"unit\":\"¥\",\"amount\":10990},\"Subway\":{\"unit\":\"¥\",\"amount\":260}},\"totalFare\":{\"unit\":\"¥\",\"amount\":12190},\"walkingSeconds\":1260,\"waitingSeconds\":6960,\"numOfTrips\":4},\"keyStops\":[{\"name\":\"丸尾\"},{\"name\":\"国分駅/国分（鹿児島）\"},{\"name\":\"鹿児島 ≪降車不要≫\"},{\"name\":\"鹿児島中央\"},{\"name\":\"博多\"},{\"name\":\"福岡空港\"}]},{\"summary\":{\"startAt\":\"2023-06-29T14:17:00+09:00\",\"endAt\":\"2023-06-29T18:42:00+09:00\",\"fares\":{\"Others\":{\"unit\":\"¥\",\"amount\":12940}},\"totalFare\":{\"unit\":\"¥\",\"amount\":12940},\"walkingSeconds\":60,\"waitingSeconds\":6420,\"numOfTrips\":4},\"keyStops\":[{\"name\":\"丸尾温泉(いわさき各社路線)\"},{\"name\":\"霧島神宮\"},{\"name\":\"鹿児島中央\"},{\"name\":\"博多\"},{\"name\":\"福岡空港(鉄道)\"}]},{\"summary\":{\"startAt\":\"2023-06-29T14:17:00+09:00\",\"endAt\":\"2023-06-29T19:34:00+09:00\",\"fares\":{\"Others\":{\"unit\":\"¥\",\"amount\":11810}},\"totalFare\":{\"unit\":\"¥\",\"amount\":11810},\"walkingSeconds\":60,\"waitingSeconds\":8280,\"numOfTrips\":4},\"keyStops\":[{\"name\":\"丸尾温泉(いわさき各社路線)\"},{\"name\":\"霧島神宮\"},{\"name\":\"鹿児島中央\"},{\"name\":\"博多\"},{\"name\":\"福岡空港(鉄道)\"}]},{\"summary\":{\"startAt\":\"2023-06-29T17:02:00+09:00\",\"endAt\":\"2023-06-29T20:43:00+09:00\",\"fares\":{\"Others\":{\"unit\":\"¥\",\"amount\":12940}},\"totalFare\":{\"unit\":\"¥\",\"amount\":12940},\"walkingSeconds\":60,\"waitingSeconds\":2460,\"numOfTrips\":4},\"keyStops\":[{\"name\":\"丸尾温泉(いわさき各社路線)\"},{\"name\":\"霧島神宮\"},{\"name\":\"鹿児島中央\"},{\"name\":\"博多\"},{\"name\":\"福岡空港(鉄道)\"}]},{\"summary\":{\"startAt\":\"2023-06-29T17:02:00+09:00\",\"endAt\":\"2023-06-29T21:28:00+09:00\",\"fares\":{\"Others\":{\"unit\":\"¥\",\"amount\":11810}},\"totalFare\":{\"unit\":\"¥\",\"amount\":11810},\"walkingSeconds\":60,\"waitingSeconds\":5760,\"numOfTrips\":4},\"keyStops\":[{\"name\":\"丸尾温泉(いわさき各社路線)\"},{\"name\":\"霧島神宮\"},{\"name\":\"鹿児島中央\"},{\"name\":\"博多\"},{\"name\":\"福岡空港(鉄道)\"}]},{\"summary\":{\"startAt\":\"2023-06-29T14:17:00+09:00\",\"endAt\":\"2023-06-29T21:29:00+09:00\",\"fares\":{\"Others\":{\"unit\":\"¥\",\"amount\":7970}},\"totalFare\":{\"unit\":\"¥\",\"amount\":7970},\"walkingSeconds\":720,\"waitingSeconds\":7380,\"numOfTrips\":4},\"keyStops\":[{\"name\":\"丸尾温泉(いわさき各社路線)\"},{\"name\":\"国分駅前(鹿児島県・高速・連絡バス)\"},{\"name\":\"鹿児島空港(高速・連絡バス)\"},{\"name\":\"筑紫野(高速・連絡バス)\"},{\"name\":\"福岡空港国内線(高速・連絡バス)\"}]},{\"summary\":{\"startAt\":\"2023-06-29T14:17:00+09:00\",\"endAt\":\"2023-06-29T21:34:00+09:00\",\"fares\":{\"Others\":{\"unit\":\"¥\",\"amount\":7670}},\"totalFare\":{\"unit\":\"¥\",\"amount\":7670},\"walkingSeconds\":960,\"waitingSeconds\":6240,\"numOfTrips\":4},\"keyStops\":[{\"name\":\"丸尾温泉(いわさき各社路線)\"},{\"name\":\"国分駅前(鹿児島県・高速・連絡バス)\"},{\"name\":\"鹿児島空港(高速・連絡バス)\"},{\"name\":\"天神\"},{\"name\":\"福岡空港(鉄道)\"}]}]"
        return jsonMapper.decodeFromString(json)
    }
}
