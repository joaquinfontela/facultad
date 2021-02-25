import React, { MouseEventHandler } from 'react';
import './ButtonMenu.css'
import { MenuButton } from './MenuButton/MenuButton'


interface ButtonMenuProps {
    onClick: Function,
    enabledMenu: boolean
}

export class ButtonMenu extends React.Component<ButtonMenuProps> {

    constructor(props: any) {
        super(props);
    }

    render(): JSX.Element {
        return (
            <div className="buttonMenu">
                <MenuButton text="DISPONIBLES" onClick={() => this.props.onClick('available')} enabled={this.props.enabledMenu} />
                <MenuButton text="RESTANTES" onClick={() => this.props.onClick('remaining')} enabled={this.props.enabledMenu} />
                <MenuButton text="CREDITOS" onClick={() => this.props.onClick('credits')} enabled={this.props.enabledMenu} />
                <MenuButton text="APROBADAS" onClick={() => this.props.onClick('passed')} enabled={this.props.enabledMenu} />
                <MenuButton text="ACTUALIZAR" onClick={() => this.props.onClick('update')} enabled={this.props.enabledMenu} />
                <MenuButton text="AYUDA" onClick={() => this.props.onClick('help')} enabled={true} />
            </div>
        );
    }
}