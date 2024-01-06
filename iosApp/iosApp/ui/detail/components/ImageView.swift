//
//  ImageView.swift
//  iosApp
//
//  Created by mijeong ko on 1/4/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ImageView: View {
    var imageName: String = "Group 14372"
    var width: CGFloat = 30
    var height: CGFloat = 30
    
    var body: some View {
        Image(imageName)
        .frame(width: width, height: height)
    }
}

#Preview {
    ImageView()
}
