/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HyperstackControls.java
 *
 * Created on Jul 15, 2010, 2:54:37 PM
 */

package org.micromanager.acquisition;

import ij.IJ;
import ij.ImageListener;
import ij.ImagePlus;
import ij.ImageStack;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import mmcorej.TaggedImage;
import org.micromanager.utils.NumberUtils;
import org.micromanager.utils.ReportingUtils;

/**
 *
 * @author arthur
 */
public class HyperstackControls extends java.awt.Panel implements ImageListener {
   private final MMVirtualAcquisition acq_;

    /** Creates new form HyperstackControls */
    public HyperstackControls(MMVirtualAcquisition acq) {
        initComponents();
        acq_ = acq;
        fpsField.setText(NumberUtils.doubleToDisplayString(acq_.getPlaybackFPS()));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      metadataButton = new javax.swing.JButton();
      showFolderButton = new javax.swing.JButton();
      contrastButton = new javax.swing.JButton();
      saveButton = new javax.swing.JButton();
      fpsField = new javax.swing.JTextField();
      fpsLabel = new javax.swing.JLabel();
      abortButton = new javax.swing.JButton();
      statusLineLabel = new javax.swing.JLabel();
      jToggleButton1 = new javax.swing.JToggleButton();

      setPreferredSize(new java.awt.Dimension(512, 30));

      metadataButton.setBackground(new java.awt.Color(255, 255, 255));
      metadataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/micromanager/icons/application_view_list.png"))); // NOI18N
      metadataButton.setToolTipText("View metadata and edit comments");
      metadataButton.setFocusable(false);
      metadataButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      metadataButton.setMaximumSize(new java.awt.Dimension(30, 28));
      metadataButton.setMinimumSize(new java.awt.Dimension(30, 28));
      metadataButton.setPreferredSize(new java.awt.Dimension(30, 28));
      metadataButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      metadataButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            metadataButtonActionPerformed(evt);
         }
      });

      showFolderButton.setBackground(new java.awt.Color(255, 255, 255));
      showFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/micromanager/icons/folder.png"))); // NOI18N
      showFolderButton.setToolTipText("Show containing folder");
      showFolderButton.setFocusable(false);
      showFolderButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      showFolderButton.setMaximumSize(new java.awt.Dimension(30, 28));
      showFolderButton.setMinimumSize(new java.awt.Dimension(30, 28));
      showFolderButton.setPreferredSize(new java.awt.Dimension(30, 28));
      showFolderButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      showFolderButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            showFolderButtonActionPerformed(evt);
         }
      });

      contrastButton.setBackground(new java.awt.Color(255, 255, 255));
      contrastButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/micromanager/icons/contrast.png"))); // NOI18N
      contrastButton.setToolTipText("Adjust brightness and contrast");
      contrastButton.setFocusable(false);
      contrastButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      contrastButton.setMaximumSize(new java.awt.Dimension(30, 28));
      contrastButton.setMinimumSize(new java.awt.Dimension(30, 28));
      contrastButton.setPreferredSize(new java.awt.Dimension(30, 28));
      contrastButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      contrastButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            contrastButtonActionPerformed(evt);
         }
      });

      saveButton.setBackground(new java.awt.Color(255, 255, 255));
      saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/micromanager/icons/disk.png"))); // NOI18N
      saveButton.setToolTipText("Save as...");
      saveButton.setFocusable(false);
      saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      saveButton.setMaximumSize(new java.awt.Dimension(30, 28));
      saveButton.setMinimumSize(new java.awt.Dimension(30, 28));
      saveButton.setPreferredSize(new java.awt.Dimension(30, 28));
      saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

      fpsField.setToolTipText("Set the speed at which the acquisition is played back.");
      fpsField.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusLost(java.awt.event.FocusEvent evt) {
            fpsFieldFocusLost(evt);
         }
      });
      fpsField.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyReleased(java.awt.event.KeyEvent evt) {
            fpsFieldKeyReleased(evt);
         }
      });

      fpsLabel.setText("playback fps:");

      abortButton.setBackground(new java.awt.Color(255, 255, 255));
      abortButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/micromanager/icons/cancel.png"))); // NOI18N
      abortButton.setToolTipText("Stop acquisition");
      abortButton.setFocusable(false);
      abortButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      abortButton.setMaximumSize(new java.awt.Dimension(30, 28));
      abortButton.setMinimumSize(new java.awt.Dimension(30, 28));
      abortButton.setPreferredSize(new java.awt.Dimension(30, 28));
      abortButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      abortButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            abortButtonActionPerformed(evt);
         }
      });

      statusLineLabel.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N

      jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/micromanager/icons/control_pause.png"))); // NOI18N
      jToggleButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
      jToggleButton1.setMaximumSize(new java.awt.Dimension(30, 28));
      jToggleButton1.setMinimumSize(new java.awt.Dimension(30, 28));
      jToggleButton1.setPreferredSize(new java.awt.Dimension(30, 28));
      jToggleButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/micromanager/icons/resultset_next.png"))); // NOI18N
      jToggleButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/micromanager/icons/resultset_next.png"))); // NOI18N
      jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jToggleButton1ActionPerformed(evt);
         }
      });

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(showFolderButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(layout.createSequentialGroup()
                  .add(30, 30, 30)
                  .add(saveButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(abortButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(0, 0, 0)
            .add(jToggleButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(3, 3, 3)
            .add(metadataButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
            .add(contrastButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(11, 11, 11)
            .add(fpsLabel)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(fpsField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(statusLineLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(showFolderButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(saveButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                  .add(fpsField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                  .add(fpsLabel)
                  .add(statusLineLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
               .add(abortButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(jToggleButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(metadataButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(contrastButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
      );
   }// </editor-fold>//GEN-END:initComponents

   private void showFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showFolderButtonActionPerformed
      acq_.showFolder();
   }//GEN-LAST:event_showFolderButtonActionPerformed

   private void contrastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrastButtonActionPerformed
      IJ.runPlugIn("ij.plugin.frame.ContrastAdjuster", "");
   }//GEN-LAST:event_contrastButtonActionPerformed

   private void metadataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metadataButtonActionPerformed
      MetadataViewer.showMetadataViewer();
   }//GEN-LAST:event_metadataButtonActionPerformed

   private void fpsFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fpsFieldFocusLost
      updateFPS();
   }//GEN-LAST:event_fpsFieldFocusLost

   private void fpsFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fpsFieldKeyReleased
      updateFPS();
   }//GEN-LAST:event_fpsFieldKeyReleased

   private void abortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abortButtonActionPerformed
      acq_.abort();
   }//GEN-LAST:event_abortButtonActionPerformed

   private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
      boolean newPauseState = acq_.pause();
}//GEN-LAST:event_jToggleButton1ActionPerformed

   private void updateFPS() {
      try {
         double fps = NumberUtils.displayStringToDouble(fpsField.getText());
         acq_.setPlaybackFPS(fps);
      } catch (ParseException ex) {}
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton abortButton;
   private javax.swing.JButton contrastButton;
   private javax.swing.JTextField fpsField;
   private javax.swing.JLabel fpsLabel;
   private javax.swing.JToggleButton jToggleButton1;
   private javax.swing.JButton metadataButton;
   private javax.swing.JButton saveButton;
   private javax.swing.JButton showFolderButton;
   private javax.swing.JLabel statusLineLabel;
   // End of variables declaration//GEN-END:variables

   public void imageOpened(ImagePlus ip) {}

   public void imageClosed(ImagePlus ip) {}

   public void imageUpdated(ImagePlus imp) {

      ImageStack stack = imp.getStack();
      if (stack instanceof AcquisitionVirtualStack) {
         AcquisitionVirtualStack vstack = (AcquisitionVirtualStack) imp.getStack();
         int slice = imp.getCurrentSlice();
         TaggedImage taggedImg = vstack.getTaggedImage(slice);
         try {
            String time = NumberUtils.doubleStringCoreToDisplay(taggedImg.tags.get("Acquisition-TimeMs"));
            String channelName = taggedImg.tags.get("Acquisition-ChannelName");
            String pixelSize = NumberUtils.doubleStringCoreToDisplay(taggedImg.tags.get("Acquisition-PixelSizeUm"));
            statusLineLabel.setText("<html>" + time + " s, " + channelName + ", " + pixelSize + " &#181;m/px</html>");
         } catch (Exception ex) {
            ReportingUtils.logError(ex);
         }
      }

   }

}
