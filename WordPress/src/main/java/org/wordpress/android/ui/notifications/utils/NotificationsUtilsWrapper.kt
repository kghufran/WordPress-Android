package org.wordpress.android.ui.notifications.utils

import android.text.Spannable
import android.widget.TextView
import org.json.JSONObject
import org.wordpress.android.fluxc.tools.FormattableContent
import org.wordpress.android.fluxc.tools.FormattableContentMapper
import org.wordpress.android.ui.notifications.blocks.NoteBlock
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Injectable wrapper around NotificationsUtils.
 *
 * NotificationsUtils interface is consisted of static methods, which make the client code difficult to test/mock.
 * Main purpose of this wrapper is to make testing easier.
 *
 */
@Singleton
class NotificationsUtilsWrapper @Inject constructor(val formattableContentMapper: FormattableContentMapper) {
    fun getSpannableContentForRanges(subject: FormattableContent?): Spannable = NotificationsUtils
            .getSpannableContentForRanges(subject, null, null, false)

    fun getSpannableContentForRanges(subject: JSONObject): Spannable = NotificationsUtils.getSpannableContentForRanges(
            formattableContentMapper, subject, null, null, false)

    fun getSpannableContentForRanges(
        blockObject: JSONObject,
        textView: TextView?,
        onNoteBlockTextClickListener: NoteBlock.OnNoteBlockTextClickListener?,
        isFooter: Boolean
    ): Spannable = NotificationsUtils.getSpannableContentForRanges(formattableContentMapper, blockObject, textView,
            onNoteBlockTextClickListener, isFooter)

    /**
     * Returns a spannable with formatted content based on WP.com note content 'range' data
     *
     * @param formattableContent the data
     * @param textView the TextView that will display the spannnable
     * @param onNoteBlockTextClickListener - click listener for ClickableSpans in the spannable
     * @param isFooter - Set if spannable should apply special formatting
     * @return Spannable string with formatted content
     */
    fun getSpannableContentForRanges(
        formattableContent: FormattableContent?,
        textView: TextView?,
        onNoteBlockTextClickListener: NoteBlock.OnNoteBlockTextClickListener?,
        isFooter: Boolean
    ): Spannable = NotificationsUtils.getSpannableContentForRanges(formattableContent,
            textView, onNoteBlockTextClickListener, isFooter)

    fun mapJsonToFormattablbeContent(blockObject: JSONObject): FormattableContent = NotificationsUtils
            .mapJsonToFormattableContent(formattableContentMapper, blockObject)
}
