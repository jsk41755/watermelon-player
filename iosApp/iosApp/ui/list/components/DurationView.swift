//
//  DurationView.swift
//  iosApp
//
//  Created by mijeong ko on 1/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct DurationView: View {
    let duration: String
    var color: Color = Color(red: 0.6, green: 0.6, blue: 0.6)
    
    var body: some View {
        Text("3:02")
          .font(Font.custom("Pretendard", size: 14))
          .multilineTextAlignment(.trailing)
          .foregroundColor(color)
    }
}

#Preview {
    DurationView(duration: "3:02")
}
