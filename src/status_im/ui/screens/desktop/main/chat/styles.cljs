(ns status-im.ui.screens.desktop.main.chat.styles
  (:require [status-im.ui.components.colors :as colors]))

(def min-input-container-height 68)
(def max-input-container-height 180)
(def chat-vertical-padding 16)
(def min-input-area-height 20)
(def max-input-area-height (- max-input-container-height (* 2 chat-vertical-padding)))

(defn message-box [{:keys [outgoing] :as message}]
  (let [align (if outgoing :flex-end :flex-start)
        color (if outgoing colors/hawkes-blue colors/white)]
    {:align-self       align
     :background-color color
     :border-radius    8
     :padding-left     12
     :padding-right    12
     :padding-top      10
     :padding-bottom   10
     :max-width        340}))

(defn message-row [{:keys [outgoing first-in-group?] :as message}]
  (let [padding-horizontal (if outgoing :padding-right :padding-left)
        padding-top-value (if first-in-group? 16 8)]
    {padding-horizontal 24
     :padding-top       padding-top-value}))

(def message-row-column
  {:flex-direction :column})

(defn message-timestamp-placeholder []
  {:color               colors/transparent
   :font-size           10
   :align-self          :flex-end
   :opacity             0.5
   :text-align          :right
   :text-align-vertical :center
   :width               60})

(defn message-timestamp []
  (merge (message-timestamp-placeholder)
         {:color    colors/gray
          :position :absolute
          :bottom   0
          :right    -5}))

(def message-command-container
  {:align-self         :flex-start
   :border-radius      8
   :padding-horizontal 12
   :padding-vertical   10
   :background-color   colors/white
   :align-items        :flex-start
   :width              230})

(def author
  {:color         colors/gray
   :font-size     12
   :margin-left   48
   :margin-bottom 4})

(defn chat-box [height]
  {:height            (+ height (* 2 chat-vertical-padding))
   :min-height        min-input-container-height
   :max-height        max-input-container-height
   :padding-vertical  chat-vertical-padding
   :flex-direction    :row
   :overflow          :hidden})

(defn chat-text-input [container-height]
  {:height            container-height
   :min-height        min-input-area-height
   :max-height        max-input-area-height
   :margin-left       20
   :margin-right      22
   :flex              1
   :align-self       :center})

(def messages-view
  {:flex             1
   :background-color colors/gray-lighter})

(def img-container
  {:height          56
   :justify-content :center})

(def messages-list-vertical-padding 46)

(def photo-style
  {:border-radius 20
   :width         40
   :height        40
   :margin-right  8})

(def chat-icon
  {:width         34
   :border-radius 34
   :height        34
   :margin-right  12})

(defn topic-image [color]
  (merge chat-icon
         {:background-color color
          :align-items      :center
          :justify-content  :center}))

(def topic-text
  {:font-size 18.7
   :color     colors/white})

(def toolbar-chat-view
  {:align-items        :center
   :padding-vertical   17
   :padding-horizontal 24
   :height             68
   :flex-direction     :row
   :justify-content    :space-between})

(def add-contact-text
  {:font-size 12
   :color     colors/blue})

(def public-chat-text
  {:font-size 12
   :color colors/gray})

(defn profile-actions-text [color]
  {:font-size 12
   :color color
   :margin-bottom 4})

(def message-wrapper
  {:flex-direction  :row
   :flex-wrap       :wrap})

(def not-first-in-group-wrapper
  {:flex-direction :row})

(def send-button
  {:height           34
   :width            34
   :margin-right     24
   :justify-content  :center
   :align-items      :center
   :align-self       :flex-end})

(defn send-icon [not-active?]
  {:height           34
   :width            34
   :border-radius    17
   :background-color (if not-active? colors/gray-lighter colors/blue)
   :align-items      :center
   :justify-content  :center
   :transform        [{:rotate "90deg"}]})

(defn send-icon-arrow [not-active?]
  {:tint-color (if not-active? :gray :white)})

(def chat-view
  {:flex             1
   :background-color :white})

(defn contact-card-text [color]
  {:color     color
   :font-size 14})

(def contact-card-gray-text
  {:color     colors/gray
   :font-size 14})

(def chat-profile-body
  {:margin 32})

(def chat-profile-row
  {:flex-direction :row
   :align-items    :center
   :margin-bottom  10})

(def chat-profile-icon-container
  {:background-color (colors/alpha colors/blue 0.1)
   :justify-content  :center
   :align-items      :center
   :border-radius    15
   ;; not sure idiomatic reagent for multiple style values
   ;; for margin
   :width            22
   :height           22
   :margin-right     10})

(defn chat-profile-icon [color]
  {:tint-color color
   :width      15
   :height     15})

(def chat-profile-contact-code
  {:color         colors/gray
   :margin-top    10
   :margin-bottom 5})

(defn chat-title-and-type [pending?]
  {:flex 1
   :justify-content (if pending? :flex-start :center)})

(def chat-title
  {:margin-bottom  4
   :font-size      14
   :color          colors/black})
