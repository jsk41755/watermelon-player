//
//  DetailImageView.swift
//  iosApp
//
//  Created by mijeong ko on 1/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct DetailImageView: View {
    var body: some View {
        Rectangle()
          .foregroundColor(.clear)
          .frame(width: 344, height: 344)
          .background(
            Image("PATH_TO_IMAGE")
              .resizable()
              .aspectRatio(contentMode: .fill)
              .frame(width: 344, height: 344)
              .clipped()
          )
          .cornerRadius(50)
          .shadow(color: .black.opacity(0.15), radius: 5, x: 0, y: 4)
          .overlay(
            RoundedRectangle(cornerRadius: 50)
              .inset(by: 0.5)
              .stroke(.black.opacity(0.2), lineWidth: 1)
          )
    }
}

#Preview {
    DetailImageView()
}
