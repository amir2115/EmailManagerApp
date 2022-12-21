package com.example.data.mock

import com.example.domain.model.message.*

val mockMessagesData = GetMessagesResponse(
    member = listOf(
        generateMessage(),
        generateMessage(),
        generateMessage(),
        generateMessage(),
        generateMessage(),
        generateMessage(),
    ),
    totalItems = 0,
    search = null,
    view = null
)

val mockMessageData = GetMessageResponse(
    context = "String",
    type = "String",
    accountId = "String",
    createdAt = "String",
    downloadUrl = "String",
    from = From(
        address = "safrg",
        name = "salam"
    ),
    hasAttachments = false,
    id = "String",
    isDeleted = false,
    msgid = "String",
    seen = false,
    size = 0,
    subject = "Random Bank Online",
    to = listOf(
        To(
            address = "safrg",
            name = "salam"
        )
    ),
    updatedAt = "Strin",
    attachments = listOf(),
    bcc = listOf(),
    cc = listOf(),
    flagged = false,
    html = listOf(),
    retention = true,
    retentionDate = "",
    text = "",
    verifications = listOf()
)

private fun generateMessage(): HydraMember {
    return HydraMember(
        context = "String",
        type = "String",
        accountId = "String",
        createdAt = "String",
        downloadUrl = "String",
        from = From(
            address = "safrg",
            name = "salam"
        ),
        hasAttachments = false,
        id = "String",
        intro = "Time to check your bank information an..",
        isDeleted = false,
        msgid = "String",
        seen = false,
        size = 0,
        subject = "Random Bank Online",
        to = listOf(
            To(
                address = "safrg",
                name = "salam"
            )
        ),
        updatedAt = "Strin"
    )
}