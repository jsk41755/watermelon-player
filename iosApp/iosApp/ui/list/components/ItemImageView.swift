//
//  ItemImageView.swift
//  iosApp
//
//  Created by mijeong ko on 1/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ItemImageView: View {
    var body: some View {
        Rectangle()
        .foregroundColor(.clear)
        .frame(width: 60, height: 60)
        .background(
          Image("active_like")
            .resizable()
            .aspectRatio(contentMode: .fit)
            .clipped()
        )
        .background(Color(red: 0.85, green: 0.85, blue: 0.85))
        .cornerRadius(18)
    }
}

#Preview {
    ItemImageView()
}
