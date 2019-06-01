package xyz.tder.androidtextspandemo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.text.style.ReplacementSpan;

/**
 * TagSpan
 *
 * @author tianbin
 * @date 2019/6/1
 */
public class TagSpan extends ReplacementSpan {

    private final Paint mTagPaint;
    private final int mTagTextColor;
    private final int mTagBackgroundColor;

    private int mSize;
    private int mRadiusPx;
    private int mRightMarginPx;
    private int mTextLeftPadding;
    private int mTextRightPadding;
    private int mRectTopPaddingPx;
    private int mRectBottomPaddingPx;

    private Paint.Style mTagStyle;

    TagSpan(Paint.Style tagStyle, int tagTextColor, int tagBackgroundColor, int textSizePx, int radiusPx) {
        this(tagStyle, tagTextColor, tagBackgroundColor, textSizePx, radiusPx, 0, 0, 0);
    }

    TagSpan(Paint.Style tagStyle, int tagTextColor, int tagBackgroundColor, int textSizePx, int radiusPx, int rightMarginPx) {
        this(tagStyle, tagTextColor, tagBackgroundColor, textSizePx, radiusPx, rightMarginPx, 0, 0);
    }

    TagSpan(Paint.Style tagStyle, int tagTextColor, int tagBackgroundColor, int textSizePx, int radiusPx, int rightMarginPx, int textLeftPadding, int textRightPadding) {
        this(tagStyle, tagTextColor, tagBackgroundColor, textSizePx, radiusPx, rightMarginPx, textLeftPadding, textRightPadding, 0, 0);
    }

    TagSpan(Paint.Style tagStyle, int tagTextColor, int tagBackgroundColor, int textSizePx, int radiusPx, int rightMarginPx, int textLeftPadding, int textRightPadding, int rectTopPaddingPx, int rectBottomPaddingPx) {
        mTagStyle = tagStyle;
        mTagTextColor = tagTextColor;
        mTagBackgroundColor = tagBackgroundColor;

        mRadiusPx = radiusPx;
        mRightMarginPx = rightMarginPx;

        mTextLeftPadding = textLeftPadding;
        mTextRightPadding = textRightPadding;

        mRectTopPaddingPx = rectTopPaddingPx;
        mRectBottomPaddingPx = rectBottomPaddingPx;

        mTagPaint = new Paint();
        mTagPaint.setTextSize(textSizePx);
        mTagPaint.setColor(mTagTextColor);
        mTagPaint.setAntiAlias(true);
        mTagPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    public int getSize(@NonNull Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        mSize = (int) mTagPaint.measureText(text, start, end) + mRightMarginPx + mTextLeftPadding + mTextRightPadding;
        return mSize;
    }

    @Override
    public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        RectF rect = createRect(x, y, paint);
        drawTagRect(canvas, paint, rect);
        drawTagText(canvas, text, start, end, rect);
    }

    private RectF createRect(float x, int y, Paint paint) {
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        final float strokeWidth = paint.getStrokeWidth();
        float left = x + strokeWidth + 0.5f;
        int top = y + fontMetrics.ascent + mRectTopPaddingPx;
        float right = x + mSize + strokeWidth + 0.5f - mRightMarginPx;
        int bottom = y + fontMetrics.descent - mRectBottomPaddingPx;
        return new RectF(left, top, right, bottom);
    }

    private void drawTagRect(Canvas canvas, Paint paint, RectF rect) {
        paint.setColor(mTagBackgroundColor);
        paint.setAntiAlias(true);

        paint.setStyle(mTagStyle);
        canvas.drawRoundRect(rect, mRadiusPx, mRadiusPx, paint);
    }

    private void drawTagText(Canvas canvas, CharSequence text, int start, int end, RectF rect) {


        Paint.FontMetricsInt tagFontMetrics = mTagPaint.getFontMetricsInt();
        final float textCenterX = (rect.right - rect.left) / 2;
        final float rectCenterY = rect.bottom - (rect.bottom - rect.top) / 2;
        final float tagBaseLineY = rectCenterY + (tagFontMetrics.descent - tagFontMetrics.ascent) / 2f - tagFontMetrics.descent;

        final String tag = text.subSequence(start, end).toString();
        canvas.drawText(tag, textCenterX, tagBaseLineY, mTagPaint);
    }
}
