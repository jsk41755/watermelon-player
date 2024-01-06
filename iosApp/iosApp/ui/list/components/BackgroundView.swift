//
//  BackgroundView.swift
//  iosApp
//
//  Created by mijeong ko on 1/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct BackgroundView: View {
    var body: some View {
        Rectangle()
          .foregroundColor(.clear)
          .frame(width: 344, height: 100)
          .background(Color(red: 0.13, green: 0.13, blue: 0.13))
          .cornerRadius(25)
          .shadow(color: .black.opacity(0.15), radius: 5, x: 0, y: 4)
          .overlay(
            RoundedRectangle(cornerRadius: 25)
              .inset(by: 0.5)
              .stroke(.black.opacity(0.2), lineWidth: 1)
          )
    }
}

#Preview {
    BackgroundView()
}
