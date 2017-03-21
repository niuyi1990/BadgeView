# BadgeView
自定义带有角标小红点数字的View
#布局文件可直接使用

        <com.soft.niuyi.badgeview.view.BadgeView
            android:id="@+id/bv_one"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            app:badgeImageIcon="@mipmap/ic_launcher"
            app:badgeText="首页"
            app:badgeTextColor="@android:color/black"
            app:badgeTextSize="15sp"/>
#代码中提供如下方法供使用
###setBadgeText 设置文字
###setBadgeTextSize 设置文字大小
###setBadgeTextColor 设置文字颜色
###setBadgeIcon 设置图标
###setRedCount 设置小红点是否显示 0不显示，>0显示
###addRedCountNumber 设置添加红点显示数量
