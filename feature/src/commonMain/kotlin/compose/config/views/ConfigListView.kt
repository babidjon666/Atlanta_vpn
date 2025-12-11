package compose.config.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import atlanta_vpn.composeapp.generated.resources.Res
import atlanta_vpn.composeapp.generated.resources.refresh
import compose.ConfigCard
import compose.Memo
import compose.ProgressBar
import compose.RoundButton
import compose.SubTimeInfo
import compose.config.viewModel.models.ConfigEvent
import compose.config.viewModel.models.ConfigState
import kotlinx.datetime.Instant
import kotlinx.datetime.toLocalDateTime
import ui.AtlantaColors
import utils.AtlantaText

import kotlinx.datetime.TimeZone
import kotlin.time.ExperimentalTime


@Composable
fun ConfigListView(state: ConfigState, evenHandler: (ConfigEvent) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).safeContentPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(113.dp))

        AtlantaText(
            text = "Активные ключи",
            weight = 700f,
            size = 35f,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 26.dp, end = 26.dp, bottom = 21.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(30.dp))
                .background(AtlantaColors.Gray0),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                state.subResponse!!.response?.let { response ->
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 23.dp, end = 23.dp, top = 18.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AtlantaText(
                            text = "Atlanta VPN",
                            weight = 700f,
                            size = 20f,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(46.dp))
                        SubTimeInfo(formatDate(response.user!!.expiresAt!!))
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))

                state.subResponse.response?.let { response ->
                    ProgressBar(
                        isStatic = response.user!!.trafficLimit == "0",
                        usedValue = response.user!!.trafficUsed!!,
                        maxValue = response.user!!.trafficLimit!!
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 23.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        val maxTraffic = if (response.user!!.trafficLimit == "0") {
                            "∞"
                        } else {
                            response.user!!.trafficLimit
                        }
                        AtlantaText(
                            text = "${response.user!!.trafficUsed} / $maxTraffic",
                            weight = 400f,
                            size = 10f,
                            color = Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(9.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 23.dp, end = 23.dp, bottom = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Memo(state.message)
                    Spacer(modifier = Modifier.width(11.dp))
                    RoundButton(
                        color = Color.Black,
                        icon = Res.drawable.refresh,
                        iconWidth = 20.dp,
                        iconHeight = 20.dp,
                        isNeedPadding = false
                    ) {

                    }
//                    RoundButton(
//                        color = AtlantaColors.Telegram,
//                        icon = Res.drawable.telegram,
//                        iconWidth = 19.dp,
//                        iconHeight = 16.dp,
//                        isNeedPadding = true
//                    ) {
//
//                    }
                }
            }
            if (state.message != "Вы достигли максимального количества устройств или не включен заголовок HWID") {
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn {
                    for (config in state.signBoxConfig?.outbounds?.get(0)?.outbounds!!) {
                        item {
                            ConfigCard(text = config) {}
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalTime::class)
fun formatDate(dateString: String): String {
    return try {
        val instant = Instant.parse(dateString)
        val date = instant.toLocalDateTime(TimeZone.UTC).date

        val day = date.dayOfMonth.toString().padStart(2, '0')
        val month = date.monthNumber.toString().padStart(2, '0')
        val year = date.year.toString()

        "$day.$month.$year"
    } catch (e: Exception) {
        ""
    }
}