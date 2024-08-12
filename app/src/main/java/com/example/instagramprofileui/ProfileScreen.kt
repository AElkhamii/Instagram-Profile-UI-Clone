package com.example.instagramprofileui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
){
    var selectedTabeRemember by remember {
        mutableStateOf(0)
    }
    Scaffold {innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
        ){
            /****** TopBar ******/
            TopBar(name = "Phillipplackner_Official", modifier = Modifier.padding(vertical = 8.dp))

            /****** Profile Section ******/
            ProfileSection()
            Spacer(modifier = Modifier.height(25.dp))

            /****** Button section ******/
            ButtonSection(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp))
            Spacer(modifier = Modifier.height(25.dp))

            /****** Story Highlight Section ******/
            HighlightSection(
                highlights = listOf(
                    ImageWithText(image = painterResource(id = R.drawable.youtube) , text = "YouTube"),
                    ImageWithText(image = painterResource(id = R.drawable.qa) , text = "Q&A"),
                    ImageWithText(image = painterResource(id = R.drawable.discord) , text = "Discord"),
                    ImageWithText(image = painterResource(id = R.drawable.telegram) , text = "Telegram"),
                    ImageWithText(image = painterResource(id = R.drawable.discord) , text = "Discord"),
                    ImageWithText(image = painterResource(id = R.drawable.telegram) , text = "Telegram"),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))


            /****** Tabs layout Section ******/
            PostTabView(
                imageWithText = listOf(
                    ImageWithText(image = painterResource(id = R.drawable.ic_grid), text = "Posts"),
                    ImageWithText(image = painterResource(id = R.drawable.ic_reels), text = "Reels"),
                    ImageWithText(image = painterResource(id = R.drawable.ic_igtv), text = "IGTV"),
                    ImageWithText(image = painterResource(id = R.drawable.profile), text = "Profile")
                )
            ) {
                selectedTabeRemember = it
            }

            when(selectedTabeRemember){
                0->{
                    /****** Posts Section ******/
                    PostsSection(
                        posts = listOf(
                            painterResource(id = R.drawable.kmm),
                            painterResource(id = R.drawable.intermediate_dev),
                            painterResource(id = R.drawable.multiple_languages),
                            painterResource(id = R.drawable.bad_habits),
                            painterResource(id = R.drawable.master_logical_thinking),
                            painterResource(id = R.drawable.learn_coding_fast),
                        ),
                        modifier = Modifier.fillMaxSize()
                    )
                }
                1->{}
                2->{}
                3->{}
            }
        }
    }
}


/****** TopBar Section ******/
@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ){
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = modifier
                .size(24.dp)
                .clickable { }
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = modifier
                .size(24.dp)
                .clickable { }
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = modifier
                .size(20.dp)
                .clickable { }
        )

    }
}



/****** Profile Section ******/
@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ){
            RoundImage(
                image = painterResource(id = R.drawable.philipp),
                modifier = modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = modifier.width(16.dp))
            StateSection(modifier = modifier.weight(7f))

        }

        /****** Profile description ******/
        ProfileDescription(
            displayName = "programming Mentor",
            description = "10 years of coding experience\n" +
                    "Want me to make your app, Send me email\n" +
                    "and subscribe to my youtube channel",
            url = "https://www.youtube.com/@PhilippLackner",
            followedBy = listOf("Ahmed","Body"),
            otherCounter = 17
        )
    }
}
// Round Image in profile section
@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(
                1f,
                matchHeightConstraintsFirst = true
            ) // to make sure it is Square shape at first
            .border( // Make Circle boarder
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(shape = CircleShape) // Make image in Circle shape
    )
}
// State section in Profile section
@Composable
fun StateSection(
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ){
        ProfileStates(numberText = "601" , text = "Posts")
        ProfileStates(numberText = "100K" , text = "Followers")
        ProfileStates(numberText = "72" , text = "Following")
    }
}
// profile state for state section
@Composable
fun ProfileStates(
    numberText: String,
    text:String,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

/****** Profile description Section ******/
@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCounter: Int,
    modifier: Modifier = Modifier
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            modifier = modifier.clickable {  }
        )

        if(followedBy.isNotEmpty()){
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    // first word
                    append("Followed by ")

                    //bold names
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if(index < followedBy.size - 1){
                            append(", ")
                        }
                    }

                    //others
                    if(otherCounter > 2){
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCounter others")
                    }

                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

/****** Button section Section ******/
@Composable
fun ButtonSection (
    modifier: Modifier = Modifier
){
    val minimumWidth = 80.dp
    val height = 30.dp

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ){
        ActionButton(
            text = "Following",
            imageVector = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minimumWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minimumWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minimumWidth)
                .height(height)
        )
        ActionButton(
            imageVector = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minimumWidth)
                .height(height)
        )
    }
}
@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text:String? = null,
    imageVector: ImageVector? = null
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
            .clickable { }
    ){
        if(text != null){
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
        if(imageVector != null){
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

/****** Story Highlight Section ******/
@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>
){
    LazyRow(
        modifier = modifier
    ){
        items(highlights.size){i ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier.padding(0.dp)
            ){
                RoundImage(
                    image = highlights[i].image,
                    modifier = Modifier
                        .size(70.dp)
                        .clickable { }
                )
                Text(
                    text = highlights[i].text,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

/****** Tabs layout Section ******/
@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
    onTabSelected: (selected: Int) -> Unit
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier.background(Color.Transparent),
        contentColor = Color.Black,
    ) {
        imageWithText.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index, //to know that tab is selected
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if(selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

/****** Posts Section ******/
@Composable
fun PostsSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)
    ) {
        items(posts.size){i->
            Image(
                painter = posts[i],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}