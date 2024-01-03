//
//  ItemView.swift
//  iosApp
//
//  Created by mijeong ko on 1/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ItemView: View {
    
    var body: some View {
        ZStack {
            BackgroundView()
    
            HStack {
                ItemImageView()
                VStack {
                    TitleView(title: "Trap Future Bass") // TEST;
                    DescriptionView(title: "RoyaltyFreeMusic") // TEST;
                }.padding(.leading, 18)
                DurationView(duration: "3:12")
            }
        }
    }
}

#Preview {
    ItemView()
}
