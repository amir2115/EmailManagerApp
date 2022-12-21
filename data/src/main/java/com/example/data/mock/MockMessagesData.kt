package com.example.data.mock

import com.example.domain.model.message.*

val mockMessagesData = GetMessagesResponse(
    member = listOf(
        generateMessage("Random Bank Online", "Time to check your bank information an.."),
        generateMessage("Fortune Company co.", "Make sure you receive these."),
        generateMessage("Stephanie Everhill", "I would meet at the Western Mall if you.."),
        generateMessage("Taylor Grey", "Hey what was our timesheet that was for.."),
        generateMessage(
            "UniqueYou by SecretKissShop",
            "Now is great time to shop great new fash.."
        ),
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

private fun generateMessage(subject: String, intro: String): HydraMember {
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
        intro = intro,
        isDeleted = false,
        msgid = "String",
        seen = false,
        size = 0,
        subject = subject,
        to = listOf(
            To(
                address = "safrg",
                name = "salam"
            )
        ),
        updatedAt = "Strin"
    )
}