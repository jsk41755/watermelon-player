//
//  DetailView.swift
//  iosApp
//
//  Created by mijeong ko on 1/4/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct DetailView: View {
    var body: some View {
        ZStack {
            VStack {
                DetailImageView()
                HStack(alignment: .center, spacing: 56) {
                    VStack {
                        TitleView(title: "title")
                        DescriptionView(title: "description")
                    }
                    
                
                    ImageView(imageName: "active_like", width: 20, height: 20)
                }
                .padding(0)
                   
                
                ZStack {
                    Rectangle()
                    .foregroundColor(.clear)
                    .frame(width: 344, height: 3)
                    .background(Color(red: 0.15, green: 0.16, blue: 0.2))
                }.padding(.top, 20)
                
                HStack(alignment: .top, spacing: 274) {
                    DurationView(duration: "1:00")
                    DurationView(duration: "1:00")
                }
                .padding(0)
              
                
                HStack(alignment: .center, spacing: 40) {
                   
                }
                .padding(0)
            }
        }
        .frame(width: 390, height: 844)
        .background(Color(red: 0.08, green: 0.08, blue: 0.08))
    }
}

#Preview {
    DetailView()
}
