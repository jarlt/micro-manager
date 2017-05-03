///////////////////////////////////////////////////////////////////////////////
//PROJECT:       Micro-Manager
//SUBSYSTEM:     Display API
//-----------------------------------------------------------------------------
//
// AUTHOR:       Chris Weisiger, 2015
//
// COPYRIGHT:    University of California, San Francisco, 2015
//
// LICENSE:      This file is distributed under the BSD license.
//               License text is included with the source distribution.
//
//               This file is distributed in the hope that it will be useful,
//               but WITHOUT ANY WARRANTY; without even the implied warranty
//               of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
//
//               IN NO EVENT SHALL THE COPYRIGHT OWNER OR
//               CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
//               INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES.

package org.micromanager.display;

import java.awt.Color;
import java.util.List;

/**
 * This class defines the parameters that control how a given DisplayWindow
 * displays data from the Datastore.
 * It is immutable; construct it with a DisplaySettingsBuilder.
 * You are not expected to implement this interface; it is here to describe how
 * you can interact with DisplaySettings created by Micro-Manager itself. If
 * you need a DisplaySettingsBuilder, you can generate one via the
 * DataManager's getDisplaySettingsBuilder() method, or by using the copy()
 * method of an existing DisplaySettings instance.
 *
 * This class uses a Builder pattern. Please see
 * https://micro-manager.org/wiki/Using_Builders
 * for more information.
 */
public interface DisplaySettings {

   interface Builder {
      Builder zoomRatio(double ratio);
      Builder playbackFPS(double fps);

      /** Color mode or lookup table for displaying the image. */
      Builder colorMode(ColorMode mode);
      Builder colorModeComposite();
      Builder colorModeGrayscale();
      Builder colorModeSingleColor();
      Builder colorModeHighlightSaturated();

      /** Whether to use the same intensity scaling for every channel. */
      Builder uniformChannelScaling(boolean enable);
      /** Whether to continuously apply autoscale. */
      Builder autostretch(boolean enable);
      Builder roiAutoscale(boolean enable);
      Builder autoscaleIgnoredQuantile(double quantile);
      Builder autoscaleIgnoredPercentile(double percentile);

      Builder channel(int channel);
      Builder channel(int channel, ChannelDisplaySettings settings);
      int getNumberOfChannels();
      ChannelDisplaySettings getChannelSettings(int channel); // Creates channel if necessary

      DisplaySettings build();
   }

   double getZoomRatio();
   double getPlaybackFPS();
   /** Color mode or lookup table for displaying the image. */
   ColorMode getColorMode();
   /** Whether to use the same intensity scaling for every channel. */
   boolean isUniformChannelScalingEnabled();
   /** Whether to continuously apply autoscale. */
   boolean isAutostretchEnabled();
   boolean isROIAutoscaleEnabled();
   double getAutoscaleIgnoredQuantile();
   double getAutoscaleIgnoredPercentile();
   int getNumberOfChannels();
   ChannelDisplaySettings getChannelSettings(int channel);
   List<ChannelDisplaySettings> getAllChannelSettings();

   // Convenience methods
   List<Color> getAllChannelColors();
   Color getChannelColor(int channel);
   List<Boolean> getAllChannelVisibilities();
   boolean isChannelVisible(int channel);

   Builder copyBuilder();
   Builder copyBuilderWithChannelSettings(int channel, ChannelDisplaySettings settings);
   Builder copyBuilderWithComponentSettings(int channel, int component, ComponentDisplaySettings settings);


   // TODO Add static builder() in Java 8


   /**
    * This object contains contrast settings for a single channel. It is used
    * to set the minimum contrast value (treated as black), maximum contrast
    * value (treated as white, or full-intensity for colored displays), and
    * gamma (how linear the mapping is between min and max).
    * This object is used for both single-component (i.e. grayscale) and
    * multi-component (e.g. RGB) channels.
    * You can create a new ContrastSettings object via
    * DisplayManager.createContrastSettings().
    */
   @Deprecated
   interface ContrastSettings {
      /**
       * Return the array of minimum contrast settings for all components.
       * @return array of minimum contrast settings (i.e. the intensity value
       * in the image that results in black display) for all components. May
       * be null.
       */
      public Integer[] getContrastMins();

      /**
       * Return the minimum contrast setting for this channel and the
       * specified component. If the contrastMins property is not set or is
       * of inadequate length, then the provided default value will be
       * returned instead.
       * @param component The component index to use. For example, for an
       *        RGB image, a value of 0 would indicate the red component.
       *        For single-component images, use an index of 0.
       * @param defaultVal Value to return if there is no value available for
       *        the specified component number.
       * @return The minimum contrast setting for the component
       */
      public Integer getSafeContrastMin(int component, Integer defaultVal);

      /**
       * Return the array of maximum contrast settings for all components.
       * @return array of maximum contrast settings (i.e. the intensity value
       * in the image that results in the brightest display value) for all
       * components. May be null.
       */
      public Integer[] getContrastMaxes();

      /**
       * Return the maximum contrast setting for this channel and the
       * specified component. If the contrastMaxes property is not set or is
       * of inadequate length, then the provided default value will be
       * returned instead.
       * @param component The component index to use. For example, for an
       *        RGB image, a value of 0 would indicate the red component.
       *        For single-component images, use an index of 0.
       * @param defaultVal Value to return if there is no value available for
       *        the specified component number.
       * @return The maximum contrast setting for the component
       */
      public Integer getSafeContrastMax(int component, Integer defaultVal);

      /**
       * Return the array of gamma settings for all components. Note that
       * multi-component images do not currently make use of the gamma setting.
       * @return Array of gamma settings for all components. May be null.
       */
      public Double[] getContrastGammas();

      /**
       * Return the gamma setting for this channel and the specified component.
       * If the contrastGammas property is not set or is of inadequate length,
       * then the provided default value will be returned instead. Note that
       * multi-component images do not currently make use of the gamma setting.
       * @param component The component index to use. For example, for an
       *        RGB image, a value of 0 would indicate the red component.
       *        For single-component images, use an index of 0.
       * @param defaultVal Value to return if there is no value available for
       *        the specified component number.
       * @return The gamma setting controlling how linear the contrast mapping
       *        is.
       */
      public Double getSafeContrastGamma(int component, Double defaultVal);

      /**
       * Nonstandard alias for {@code isVisible}.
       *
       * @return Flag indicating whether the channel is currently displayed
       * @deprecated Use {@link isVisible}
       */
      @Deprecated
      public Boolean getIsVisible();

      /**
       * Return true if the channel is currently displayed, and false
       * otherwise. This is only relevant when the display is showing
       * multiple channels at the same time (i.e. ColorMode is COMPOSITE); in
       * all other modes this value is ignored.
       * @return Flag indicating whether the channel is currently displayed
       * @deprecated Use isVisible
       */
      Boolean isVisible();

      /**
       * Return the number of components this ContrastSettings object has
       * information for. This will be the length of the smallest array from
       * the contrastMins, contrastMaxes, and contrastGammas attributes. Note
       * that it is still possible for there to be nulls in one of those
       * arrays.
       * @return The number of components this object has information for.
       */
      public int getNumComponents();
   }

   @Deprecated
   interface DisplaySettingsBuilder extends Builder {
      /**
       * Construct a DisplaySettings from the DisplaySettingsBuilder. Call
       * this once you are finished setting all DisplaySettings parameters.
       * @return Build object
       */
      @Override
      DisplaySettings build();

      // The following functions each set the relevant value for the
      // DisplaySettings. See the getters of the DisplaySettings, below,
      // for information on the meaning of these fields.
      DisplaySettingsBuilder channelColors(Color[] channelColors);
      /**
       * "Safely" update the channelColors property to include the new
       * provided color at the specified index. If the channelColors
       * property is null or is not large enough to incorporate the specified
       * index, then a new array will be created that is long enough, values
       * will be copied across, and any missing values will be null.
       * @param newColor New color for the specified channel.
       * @param channelIndex Index into the channelColors array.
       * @return builder to be used to build the new DisplaySettings
       */
      DisplaySettingsBuilder safeUpdateChannelColor(Color newColor,
            int channelIndex);
      DisplaySettingsBuilder channelContrastSettings(ContrastSettings[] contrastSettings);
      /**
       * "Safely" update the contrastSettings property to have the provided
       * ContrastSettings object at the specified index. If the
       * contrastSettings property is null or is not large enough to incorporate
       * the specified index, then a new array will be created that is long
       * enough, values will be copied across, and any missing values will be
       * null.
       * @param newSettings New ContrastSettings for the channel.
       * @param channelIndex Index into the contrastSettings array.
       * @return builder to be used to build the new DisplaySettings
       */
      DisplaySettingsBuilder safeUpdateContrastSettings(
            ContrastSettings newSettings, int channelIndex);

      @Deprecated
      DisplaySettingsBuilder magnification(Double magnification);
      DisplaySettingsBuilder zoom(Double ratio);
      DisplaySettingsBuilder animationFPS(Double animationFPS);
      DisplaySettingsBuilder channelColorMode(ColorMode channelColorMode);
      DisplaySettingsBuilder shouldSyncChannels(Boolean shouldSyncChannels);
      DisplaySettingsBuilder shouldAutostretch(Boolean shouldAutostretch);
      DisplaySettingsBuilder shouldScaleWithROI(Boolean shouldScaleWithROI);
      DisplaySettingsBuilder extremaPercentage(Double extremaPercentage);
   }

   /**
    * Generate a new DisplaySettingsBuilder whose values are initialized to be
    * the values of this DisplaySettings.
    * @return Copy of the DisplaySettingsBuilder
    */
   DisplaySettingsBuilder copy();

   /**
    * The colors of each channel in the image display window. In the case of
    * multi-component (e.g. RGB) images, this value is not used by Micro-
    * Manager.
    * @return Channel colors
    */
   @Deprecated
   public Color[] getChannelColors();

   /**
    * Safely retrieve the color for the specified channel. If the
    * channelColors property is null, is too small to have a value for the
    * given index, or has a value of null for that index, then the provided
    * default value will be returned instead.
    * @param index Channel index to get the color for
    * @param defaultVal Default value to return if no color is available.
    * @return Channel color
    */
   @Deprecated
   public Color getSafeChannelColor(int index, Color defaultVal);

   /**
    * The object containing contrast information for each channel.
    * @return An array of ContrastSettings objects, one per channel. May
    *         potentially be null or of inadequate length.
    */
   @Deprecated
   public ContrastSettings[] getChannelContrastSettings();

   /**
    * Safely retrieve the ContrastSettings object for the specified channel. If
    * the contrastSettings property is null, is too small to have a value for
    * the given index, or has a value of null for that index, then the provided
    * default value will be returned instead.
    * @param index Channel index to get the ContrastSettings for
    * @param defaultVal Default value to return if no contrast setting is
    *        available.
    * @return Contrast settings for the specified channel
    */
   @Deprecated
   public ContrastSettings getSafeContrastSettings(int index, ContrastSettings defaultVal);

   /**
    * Safely extract the channel contrast min property from the contrast
    * settings for the specified channel and component. If the
    * contrastSettings property is null, is too small to have a value for the
    * given index, has a value of null for the given index, or has a
    * ContrastSettings object whose contrastMin property is null, then the
    * provided default value will be returned instead.
    * @param index Channel index to get the contrast min for.
    * @param component Component index to get the contrast min for.
    * @param defaultVal Default value to return if no contrast min is
    *        available.
    * @return Black point for the specified channel/component
    */
   @Deprecated
   public Integer getSafeContrastMin(int index, int component, Integer defaultVal);

   /**
    * Safely extract the channel contrast max property from the contrast
    * settings for the specified channel and component. If the
    * contrastSettings property is null, is too small to have a value for the
    * given index, has a value of null for the given index, or has a
    * ContrastSettings object whose contrastMax property is null, then the
    * provided default value will be returned instead.
    * @param index Channel index to get the contrast max for.
    * @param component Component index to get the contrast max for.
    * @param defaultVal Default value to return if no contrast max is
    *        available.
    * @return White point for the specified channel/component
    */
   @Deprecated
   public Integer getSafeContrastMax(int index, int component, Integer defaultVal);

   /**
    * Safely extract the channel contrast gamma property from the contrast
    * settings for the specified channel and component. If the
    * contrastSettings property is null, is too small to have a value for the
    * given index, has a value of null for the given index, or has a
    * ContrastSettings object whose contrastGamma property is null, then the
    * provided default value will be returned instead.
    * @param index Channel index to get the contrast gamma for.
    * @param component Component index to get the contrast gamma for.
    * @param defaultVal Default value to return if no contrast gamma is
    *        available.
    * @return Gamma for the specified channel/component
    */
   @Deprecated
   public Double getSafeContrastGamma(int index, int component, Double defaultVal);

   /**
    * Safely determine if the specified channel is visible when in composite
    * view mode. If the contrastSettings property is null, is too small to
    * have a value for the given index, has a value of null for the given
    * index, or has a ContrastSettings object whose isVisible property is null,
    * then the provided default value will be returned instead.
    * @param index Channel index to get visibility for.
    * @param defaultVal Default value to return if no visibility is available.
    * @return Flag indicating visibility of the specified channel
    */
   @Deprecated
   public Boolean getSafeIsVisible(int index, Boolean defaultVal);

   /**
    * The magnification level of the canvas
    * @return magnification level of the canvas
    * @deprecated use {@code getZoom} instead
    */
   @Deprecated
   public Double getMagnification();


   /**
    * Animation speed, when animation of the display is turned on
    * @return Animation speed in frames per second
    */
   @Deprecated
   public Double getAnimationFPS();

   public enum ColorMode {
      // TODO Integer indices should be implementation detail of file format
      COLOR(0), COMPOSITE(1), GRAYSCALE(2), HIGHLIGHT_LIMITS(3), FIRE(4),
         RED_HOT(5), @Deprecated SPECTRUM(6);

      private final int index_;

      private ColorMode(int index) {
         index_ = index;
      }

      @Deprecated
      public int getIndex() {
         return index_;
      }

      @Deprecated
      public static ColorMode fromInt(int index) {
         for (ColorMode mode : ColorMode.values()) {
            if (mode.getIndex() == index) {
               return mode;
            }
         }
         return null;
      }
   }

   /**
    * The index into the "Display mode" control.
    * @return index into the "Display mode" control
    */
   @Deprecated
   public ColorMode getChannelColorMode();

   /**
    * Whether histogram settings should be synced across channels
    * @return True if histograms should sync between channels
    */
   @Deprecated
   public Boolean getShouldSyncChannels();

   /**
    * Whether each newly-displayed image should be autostretched
    * @return True if new images should be auto-stretched
    */
   @Deprecated
   public Boolean getShouldAutostretch();
   
   /**
    * Whether histogram calculations should use only the pixels in the current ROI.
    * @return True if ROI should be used
    */
   @Deprecated
   public Boolean getShouldScaleWithROI();

   /**
    * The percentage of values off the top and bottom of the image's value
    * range that get ignored when autostretching
    * @return Number used in Autostretch mode to determine where to set the
    * white and black points.  Expressed as percentage.
    */
   @Deprecated
   public Double getExtremaPercentage();

   @Deprecated
   static final String FILENAME = "displaySettings.txt";
}