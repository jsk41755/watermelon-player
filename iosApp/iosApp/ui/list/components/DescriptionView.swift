//
//  DescriptionView.swift
//  iosApp
//
//  Created by mijeong ko on 1/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct DescriptionView: View {
    let title: String
    var width: CGFloat = 180
    var alignment: Alignment = .leading
    
    var body: some View {
        Text(title)
          .font(Font.custom("Pretendard", size: 14))
          .foregroundColor(Color(red: 0.6, green: 0.6, blue: 0.6))
          .frame(width: width, alignment: alignment)
    }
}

#Preview {
    DescriptionView(title: "RoyaltyFreeMusic")
}
