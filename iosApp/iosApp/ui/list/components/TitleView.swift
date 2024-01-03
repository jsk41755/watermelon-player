//
//  TitleView.swift
//  iosApp
//
//  Created by mijeong ko on 1/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct TitleView: View {
    let title: String
    var width: CGFloat = 180
    var height: CGFloat = 24
    var alignment: Alignment = .leading
    
    var body: some View {
        Text(title)
          .font(
            Font.custom("Pretendard", size: 16)
              .weight(.bold)
          )
          .foregroundColor(.white)
          .frame(width: width, height: height, alignment: alignment)
    }
}

#Preview {
    TitleView(title: "Trap Future Bass")
}
