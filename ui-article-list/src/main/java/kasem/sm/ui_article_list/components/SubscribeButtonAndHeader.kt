/*
 * Copyright (C) 2022, Kasem S.M
 * All rights reserved.
 */
package kasem.sm.ui_article_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kasem.sm.common_ui.SlimeTypography
import kasem.sm.common_ui.VerticalSpacer
import kasem.sm.common_ui.getFont
import kasem.sm.feature_category.domain.model.Category
import kasem.sm.ui_article_list.R

@Composable
internal fun SubscribeButtonAndHeader(
    category: Category,
    onClick: () -> Unit,
    isSubscriptionButtonActive: Boolean,
    isSubscriptionInProgress: Boolean,
) {
    Column {
        Text(
            text = category.title,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth(),
            style = getFont(SlimeTypography.Medium(25.sp, 1.5.sp)),
        )

        VerticalSpacer(value = 10.dp)

        val text = if (isSubscriptionButtonActive) "Unsubscribe" else "Subscribe"
        val icon = if (isSubscriptionButtonActive) R.drawable.ic_unsubscribe else R.drawable.ic_subscribe

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            SubscribeButton(
                onClick = onClick,
                isActive = isSubscriptionButtonActive,
                text = text,
                trailingIcon = icon,
                isLoading = isSubscriptionInProgress
            )

            Text(
                text = "• ${category.totalSubscribers} Users",
                style = getFont(SlimeTypography.SecondaryMedium(15.sp)),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
